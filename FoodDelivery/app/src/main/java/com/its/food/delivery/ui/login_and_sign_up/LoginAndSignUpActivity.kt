package com.its.food.delivery.ui.login_and_sign_up

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.its.food.delivery.R
import com.its.food.delivery.databinding.ActivityLoginAndSignupBinding
import com.its.food.delivery.ui.BaseActivity
import com.its.food.delivery.ui.login_and_sign_up.fragment.LoginFragment
import com.its.food.delivery.ui.login_and_sign_up.fragment.SignUpFragment
import dagger.hilt.android.AndroidEntryPoint


//@ExperimentalCoroutinesApi
@AndroidEntryPoint
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class LoginAndSignUpActivity :
    BaseActivity<ActivityLoginAndSignupBinding, LoginAndSignUpActivityViewModel>() {
    companion object {

        private val LOGIN = LoginFragment()
        private val SIGN_UP = SignUpFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_and_signup)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel




        binding.containerLoginSignUp.adapter = ViewStateAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLoginSignUp, binding.containerLoginSignUp) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Login"
                }
                1 -> {
                    tab.text = "Sign-Up"
                }

            }
        }.attach()

    }
    private class ViewStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {
        override fun createFragment(position: Int): Fragment {
            // Hardcoded in this order, you'll want to use lists and make sure the titles match
            return if (position == 1) {
                SIGN_UP
            } else LOGIN
        }

        override fun getItemCount(): Int {
            // Hardcoded, use lists
            return 2
        }
    }

}
