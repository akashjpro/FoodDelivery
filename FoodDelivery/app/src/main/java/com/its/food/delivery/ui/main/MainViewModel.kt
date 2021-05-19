package com.its.food.delivery.ui.main

import android.view.MenuItem
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.its.food.delivery.R
import com.its.food.delivery.repository.setting.Setting
import com.its.food.delivery.ui.BaseViewModel
import com.its.food.delivery.util.extensions.valueNotDistinct
import com.its.food.delivery.util.livedata.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor(private val setting: Setting) : BaseViewModel() {

    private val _navigateToLogin by lazy { MutableStateFlow<Boolean?>(null) }
    val navigateToLogin by lazy {
        _navigateToLogin.mapNotNull { SingleEvent.createOrNull(it) }
            .asLiveData(viewModelScope.coroutineContext)
    }

    fun navClicked(menuItem: MenuItem): Boolean =
        when (menuItem.itemId) {
            R.id.navProfile -> {

                true
            }
            R.id.navSignOut -> {
                _navigateToLogin.valueNotDistinct(true)
//                saveLogin(false,"","","")
                true
            }
            R.id.navOrder -> {

                true
            }
            R.id.navOffer -> {

                true
            }
            R.id.navPrivacyPolicy -> {

                true
            }
            R.id.navSecurity -> {

                true
            }
            else -> false
        }

    fun saveLogin(value: Boolean, role: String, userId: String, token: String) {
        setting.saveLogin(value, role, userId, token)
    }
}
