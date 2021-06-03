package com.its.food.delivery.ui.main.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.its.food.delivery.R
//import com.its.food.delivery.databinding.FragmentFavoriteEmptyBinding
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.ui.main.history.HistoryEmptyFragment
import com.its.food.delivery.ui.main.history.HistoryEmptyViewModel

class FavoriteEmptyFragment : Fragment() {

    companion object {
        fun newInstance() = HistoryEmptyFragment()
    }

    private lateinit var viewModel: HistoryEmptyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_empty, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HistoryEmptyViewModel::class.java)
        // TODO: Use the ViewModel
    }


//    :
//    BaseFragment2<FragmentFavoriteEmptyBinding, FavoriteEmptyViewModel, MainViewModel>() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View? {
//        binding = FragmentFavoriteEmptyBinding.inflate(inflater, container, false)
//        binding.lifecycleOwner = this
//        binding.viewModel = this.viewModel
//        return binding.root
//    }
}