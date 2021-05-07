package com.its.food.delivery.ui.main.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.its.food.delivery.R
import com.its.food.delivery.databinding.FragmentFavoriteBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.main.MainViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment : BaseFragment2<FragmentFavoriteBinding,FavoriteViewModel,MainViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }
}