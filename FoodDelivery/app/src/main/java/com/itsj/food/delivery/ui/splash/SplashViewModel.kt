package com.itsj.food.delivery.ui.splash

import androidx.lifecycle.*
import com.itsj.food.delivery.ui.BaseViewModel
import com.itsj.food.delivery.util.extensions.valueNotDistinct
import com.itsj.food.delivery.util.livedata.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class SplashViewModel  @Inject constructor() : BaseViewModel() {

    private val _navigateToLogin by lazy { MutableStateFlow<Int?>(null) }
    val navigateToLogin by lazy {
        _navigateToLogin.mapNotNull { SingleEvent.createOrNull(it) }
            .asLiveData(viewModelScope.coroutineContext)
    }

    private val _navigateToMain by lazy { MutableStateFlow<Int?>(null) }
    val navigateToMain by lazy {
        _navigateToMain.mapNotNull { SingleEvent.createOrNull(it) }
            .asLiveData(viewModelScope.coroutineContext)
    }


    // Life cycle

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        viewModelScope.launch {
            val isLogin = true

            when {

                isLogin -> _navigateToLogin.valueNotDistinct(1)

                // User not logged in
                else -> _navigateToMain.valueNotDistinct(1)
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        // TODO: 5/3/21
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        // TODO: 5/3/21
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        // TODO: 5/3/21
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        // TODO: 5/3/21
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        // TODO: 5/3/21
    }

}