package com.its.food.delivery.ui.main.home.tab_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.its.food.delivery.R

class FoodsFragment : Fragment() {

    companion object {
        fun newInstance() = FoodsFragment()
    }

    private lateinit var viewModel: FoodsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.foods_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FoodsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}