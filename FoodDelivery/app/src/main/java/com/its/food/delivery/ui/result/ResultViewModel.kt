package com.its.food.delivery.ui.result

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.its.food.delivery.R
import com.its.food.delivery.ui.BaseViewModel
import com.its.food.delivery.ui.appContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class ResultViewModel @Inject constructor() : BaseViewModel() {

    private val _count by lazy { MutableStateFlow<String?>(null) }
    val count by lazy {
        _count.filterNotNull().asLiveData(viewModelScope.coroutineContext)
    }

    fun setCount(count: Int) {
        _count.value =
            appContext.getString(R.string.found) + " $count " + appContext.getString(R.string.results)
    }
}