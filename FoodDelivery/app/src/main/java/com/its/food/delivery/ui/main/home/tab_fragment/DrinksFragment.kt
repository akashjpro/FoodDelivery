package com.its.food.delivery.ui.main.home.tab_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.its.food.delivery.R

class DrinksFragment : Fragment() {

    companion object {
        fun newInstance() = DrinksFragment()
    }

    private lateinit var viewModel: DrinksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_drink, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DrinksViewModel::class.java)
        // TODO: Use the ViewModel
    }

}