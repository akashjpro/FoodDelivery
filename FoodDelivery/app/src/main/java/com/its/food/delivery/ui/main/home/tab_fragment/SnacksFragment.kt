package com.its.food.delivery.ui.main.home.tab_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.its.food.delivery.databinding.FragmentSnackBinding
import com.its.food.delivery.delivery_interface.ExampleListFood
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.main.MainViewModel

class SnacksFragment : BaseFragment2<FragmentSnackBinding, SnacksViewModel, MainViewModel>(),
    ExampleListFood {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSnackBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel


        return binding.root
    }

}