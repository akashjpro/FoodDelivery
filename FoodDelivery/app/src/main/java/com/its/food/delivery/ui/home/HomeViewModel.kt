package com.its.food.delivery.ui.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.its.food.delivery.ui.BaseViewModel
import com.its.food.delivery.util.extensions.valueNotDistinct
import com.its.food.delivery.util.livedata.SingleEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel(){
    private val _navigateToNoInternet by lazy { MutableStateFlow<Int?>(null) }
    val navigateToNoInternet by lazy {
        _navigateToNoInternet.mapNotNull { SingleEvent.createOrNull(it) }
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
            val isNoInternet = true

            when {

                isNoInternet -> _navigateToNoInternet.valueNotDistinct(1)

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