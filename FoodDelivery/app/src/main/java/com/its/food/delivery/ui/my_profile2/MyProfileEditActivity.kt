package com.its.food.delivery.ui.my_profile2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityMyProfileEditBinding
import com.its.food.delivery.ui.BaseActivity
import java.util.zip.Inflater

class MyProfileEditActivity : BaseActivity<ActivityMyProfileEditBinding,MyProfileEditViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_profile_edit)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
    }
}