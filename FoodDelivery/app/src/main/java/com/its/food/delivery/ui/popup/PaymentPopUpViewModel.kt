package com.its.food.delivery.ui.popup

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.its.food.delivery.ui.BaseViewModel
import com.its.food.delivery.util.livedata.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class PaymentPopUpViewModel @Inject constructor(@ApplicationContext context: Context) :
    BaseViewModel() {

    private val _closeClick by lazy {
        MutableLiveData<SingleEvent<Boolean>>()
    }
    val closeClick: LiveData<SingleEvent<Boolean>> by lazy { _closeClick }

    fun closeClick() {
        _closeClick.value = SingleEvent(true)
    }

    fun keyCodeBack() {
        closeClick()
    }
}