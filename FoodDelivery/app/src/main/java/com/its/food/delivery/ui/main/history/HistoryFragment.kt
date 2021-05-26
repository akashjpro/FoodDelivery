package com.its.food.delivery.ui.main.history

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.its.food.delivery.adapters.HistoryAdapter
import com.its.food.delivery.databinding.FragmentHistoryBinding
import com.its.food.delivery.provider.WorkoutInstance
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY

class HistoryFragment : BaseFragment2<FragmentHistoryBinding, HistoryViewModel, MainViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Data binding
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        val historyAdapter = HistoryAdapter(onItemClick = {
            val intent = Intent(this.context, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })

        historyAdapter.submitList(WorkoutInstance.getInstance().getListHistory())
        binding.recyclerviewHistory.adapter  = historyAdapter
        binding.recyclerviewHistory.layoutManager = LinearLayoutManager(this.context)


        return binding.root
    }
}