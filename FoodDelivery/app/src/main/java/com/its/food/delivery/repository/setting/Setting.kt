package com.its.food.delivery.repository.setting

import androidx.lifecycle.MutableLiveData

interface Setting {

    val firstOpen: MutableLiveData<Boolean>

    val isOpenIntroduction:Boolean

    val isLogin:Boolean

    val role:String

    val userId:String

    val token: String

    fun saveIntroduction(value: Boolean)

    fun saveLogin(value: Boolean, role:String, userId:String, token: String)
}