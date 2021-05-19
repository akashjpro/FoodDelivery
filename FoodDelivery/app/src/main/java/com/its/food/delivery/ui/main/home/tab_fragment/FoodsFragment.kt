package com.its.food.delivery.ui.main.home.tab_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.its.food.delivery.adapters.FoodAdapter
import com.its.food.delivery.databinding.FragmentFoodBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY


class FoodsFragment : BaseFragment2<FragmentFoodBinding, FoodsViewModel, MainViewModel>(),
    ExampleListFood {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFoodBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel


        val foodAdapter = FoodAdapter(onItemClick = {
            val intent = Intent(this.context, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })
        val type = "Food"
        val listFood = filterFoodType(type)
        foodAdapter.submitList(listFood)
        binding.recyclerviewFoods.adapter = foodAdapter
        binding.recyclerviewFoods.layoutManager = LinearLayoutManager(
            this.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        return binding.root
    }

}