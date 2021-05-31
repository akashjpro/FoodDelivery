package com.its.food.delivery.ui.login_and_sign_up.fragment

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.its.food.delivery.ui.BaseViewModel
import com.its.food.delivery.util.extensions.valueNotDistinct
import com.its.food.delivery.util.livedata.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : BaseViewModel() {
    private val _navigateToCreate by lazy { MutableStateFlow<Boolean?>(null) }
    val navigateToCreate by lazy {
        _navigateToCreate.mapNotNull { SingleEvent.createOrNull(it) }
            .asLiveData(viewModelScope.coroutineContext)
    }
    fun onClickCreateAccount() {
        _navigateToCreate.valueNotDistinct(true)
    }
}