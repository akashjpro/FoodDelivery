package com.its.food.delivery.ui.main.home.tab_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.its.food.delivery.R

class SnacksFragment : Fragment() {

    companion object {
        fun newInstance() = SnacksFragment()
    }

    private lateinit var viewModel: SnacksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.snacks_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SnacksViewModel::class.java)
        // TODO: Use the ViewModel
    }

}