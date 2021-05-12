package com.its.food.delivery.ui.main

import android.view.MenuItem
import com.its.food.delivery.R
import com.its.food.delivery.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    fun navClicked(menuItem: MenuItem): Boolean =
        when (menuItem.itemId) {
            R.id.navProfile -> {
                true
            }
            else -> false
        }
}
