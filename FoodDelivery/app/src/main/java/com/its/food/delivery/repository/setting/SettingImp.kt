package com.its.food.delivery.repository.setting

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.its.food.delivery.util.EMPLOYEE
import com.its.food.delivery.util.extensions.booleanLiveData
import javax.inject.Inject

class SettingImp @Inject constructor(private val sharedRef: SharedPreferences) : Setting {

    override val firstOpen: MutableLiveData<Boolean>
        get() =  sharedRef.booleanLiveData("firstOpen", false)

    override val isOpenIntroduction: Boolean
        get() = sharedRef.getBoolean("isOpenIntroduction", false)

    override val isLogin: Boolean
        get() = sharedRef.getBoolean("isLogin", false)

    override val role: String
        get() = sharedRef.getString("role", EMPLOYEE) ?: EMPLOYEE

    override val userId: String
        get() = sharedRef.getString("userId", "") ?: ""

    override val token: String
        get() = sharedRef.getString("token", "") ?: ""

    override fun saveIntroduction(value: Boolean) {
        with(sharedRef.edit()) {
            putBoolean("isOpenIntroduction", value)
            apply()
        }
    }

    override fun saveLogin(value: Boolean, role: String, userId: String, token: String) {
        with(sharedRef.edit()) {
            putBoolean("isLogin", value)
            putString("role", role)
            putString("userId", userId)
            putString("token", token)
            apply()
        }
    }
}