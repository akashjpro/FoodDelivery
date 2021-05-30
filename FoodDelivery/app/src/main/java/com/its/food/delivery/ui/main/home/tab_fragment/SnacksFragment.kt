package com.its.food.delivery.ui.main.home.tab_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.its.food.delivery.adapters.FoodAdapter
import com.its.food.delivery.databinding.FragmentSnackBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY

class SnacksFragment : BaseFragment2<FragmentSnackBinding, SnacksViewModel, MainViewModel>(),
    ExampleListFood {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSnackBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        val foodAdapter = FoodAdapter(onItemClick = {
            val intent = Intent(this.context, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })
        val type = "Snack"
        val listFood = filterFoodType(type)
//        foodAdapter.submitList(listFood)
        binding.recyclerviewSnack.adapter = foodAdapter
        binding.recyclerviewSnack.layoutManager = LinearLayoutManager(
            this.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        observe(foodAdapter)

        return binding.root
    }

    private fun observe(foodAdapter:FoodAdapter) {
        activityViewModel.foodsEntity.observe(requireActivity()) { event ->
            event.getContentIfNotHandled().let {
                foodAdapter.submitList(it)
            }
        }
    }

}