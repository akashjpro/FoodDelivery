package com.its.food.delivery.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.its.food.delivery.databinding.FragmentEmptyBinding
import com.its.food.delivery.ui.BaseFragment2


class EmptyFragment( var title: String) :
    BaseFragment2<FragmentEmptyBinding, EmptyViewModel, MainViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentEmptyBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

       binding.tvTitleEmpty.text = title

        return binding.root
    }
}