package com.its.food.delivery.ui.main.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.its.food.delivery.adapters.FoodAdapter
import com.its.food.delivery.databinding.FragmentHomeBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.ui.spicy.SpicyChiActivity
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY
import kotlinx.android.synthetic.main.activity_food_information.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment2<FragmentHomeBinding, HomeViewModel, MainViewModel>(),
    ExampleListFood {
    @SuppressLint("LogNotTimber")
    val exampleListFood = exampleLis()
    val exampleDisplayList = exampleLis()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        init()



        // Data binding
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        val foodAdapter = FoodAdapter(onItemClick = {
            val intent = Intent(this.context, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })

//        editTextSearch.


        binding.recyclerviewFoods.adapter = foodAdapter

        //Update list food
        foodAdapter.submitList(exampleListFood)

        return binding.root
    }

    private fun init() {
        lifecycle.addObserver(viewModel)
    }

    private fun nextPage() {
        val intent = Intent(this.context, SpicyChiActivity::class.java)
        startActivity(intent)
    }

}