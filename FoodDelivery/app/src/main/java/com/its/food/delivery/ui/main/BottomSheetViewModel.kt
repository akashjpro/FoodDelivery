package com.its.food.delivery.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.its.food.delivery.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomSheetViewModel @Inject constructor() : BaseViewModel() {

    private val _bottomSheetState by lazy {
        MutableLiveData<Int>()
    }
    val bottomSheetState: LiveData<Int> = _bottomSheetState

}