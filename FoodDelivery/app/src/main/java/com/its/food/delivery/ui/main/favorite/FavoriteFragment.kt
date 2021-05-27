package com.its.food.delivery.ui.main.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.its.food.delivery.R
import com.its.food.delivery.adapters.FavoriteAdapter
import com.its.food.delivery.adapters.HistoryAdapter
import com.its.food.delivery.databinding.FragmentFavoriteBinding
import com.its.food.delivery.databinding.FragmentHistoryBinding
import com.its.food.delivery.provider.WorkoutInstance
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.food_in_formation.FoodInformationActivity
import com.its.food.delivery.ui.main.MainViewModel
import com.its.food.delivery.util.BUNDLE_KEY
import com.its.food.delivery.util.FOOD_ENTITY_KEY

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment :
    BaseFragment2<FragmentFavoriteBinding, FavoriteViewModel, MainViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        val favoriteAdapter = FavoriteAdapter(onItemClick = {
            val intent = Intent(this.context, FoodInformationActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(FOOD_ENTITY_KEY, it)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
        })
        val listFavorite = WorkoutInstance.getInstance().getListFavorite()
        binding.recyclerViewFavorite.adapter = favoriteAdapter
        binding.recyclerViewFavorite.layoutManager = LinearLayoutManager(this.context)
        favoriteAdapter.submitList(listFavorite)
        return binding.root
    }
}