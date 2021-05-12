package com.its.food.delivery.ui.spicy

import android.content.Intent
import android.os.Bundle
import android.widget.Filter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.its.food.delivery.R
import com.its.food.delivery.adapters.FoodAdapter
import com.its.food.delivery.databinding.ActivitySpicyChiecrnsBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.entity.Food
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import kotlinx.android.synthetic.main.activity_spicy_chiecrns.*
import okhttp3.internal.notify

class SpicyChiActivity : BaseActivity<ActivitySpicyChiecrnsBinding, SpicyChiViewModel>(),
    ExampleListFood {
    var foodListFilterde = ArrayList<Food>()
    val exampleListFood = exampleLis()
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_spicy_chiecrns)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        val foodAdapter = FoodAdapter(onItemClick = {
            val intent = Intent(this, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })

        binding.recyclerSpicyChiecrns.adapter = foodAdapter
        binding.recyclerSpicyChiecrns.layoutManager = GridLayoutManager(this, 2)

        //Update list food
        foodAdapter.submitList(exampleListFood)
        val foodName = intent?.getBundleExtra("SEARCH_KEY")
        for (i in exampleListFood) {
            if (i.foodName.equals(foodName)) {

            }
        }

    }

    fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults? {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    foodListFilterde = exampleListFood as ArrayList<Food>
                } else {
                    val filteredList: MutableList<Food> = ArrayList()
                    for (row in exampleLis()) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.foodName.toLowerCase()
                                .contains(charString.toLowerCase()) || row.typeOfFood
                                .contains(charSequence)
                        ) {
                            filteredList.add(row)
                        }
                    }
                    foodListFilterde = filteredList as ArrayList<Food>
                }
                val filterResults = FilterResults()
                filterResults.values = foodListFilterde
                return filterResults
            }

            override fun publishResults(
                charSequence: CharSequence?,
                filterResults: FilterResults
            ) {
                foodListFilterde = filterResults.values as ArrayList<Food>
//                notify()
            }
        }
    }
}