package com.its.food.delivery.ui.checkout_payment

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import com.its.food.delivery.ui.BaseViewModel
import com.its.food.delivery.util.extensions.filterNotNull
import com.its.food.delivery.util.livedata.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckOutPaymentViewModel @Inject constructor() : BaseViewModel() {

    // Popup event
    private val _paymentPopUp by lazy {
        MutableLiveData<SingleEvent<Boolean>?>()
    }
    val paymentPopUp: LiveData<SingleEvent<Boolean>> = _paymentPopUp.filterNotNull()

    // Popup close event
    private val _paymentPopupClose by lazy {
        MutableLiveData<Boolean?>()
    }
    val paymentPopupClose: LiveData<Boolean?> = _paymentPopupClose.distinctUntilChanged()

    @WorkerThread
    fun callPopupClose() {
        _paymentPopupClose.postValue(true)
    }

    @WorkerThread
    fun callPopupShow() {
        _paymentPopUp.value = SingleEvent(true)
    }
}