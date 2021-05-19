package com.its.food.delivery.ui.main.home.tab_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.its.food.delivery.databinding.FragmentDrinkBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.main.MainViewModel


class DrinksFragment : BaseFragment2<FragmentDrinkBinding, DrinksViewModel, MainViewModel>(),
    ExampleListFood {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDrinkBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel


        return binding.root
    }
}