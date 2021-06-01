package com.its.food.delivery.ui.login_and_sign_up.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.its.food.delivery.R
import com.its.food.delivery.databinding.FragmentLoginBinding
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.login_and_sign_up.LoginAndSignUpActivityViewModel
import com.its.food.delivery.ui.main.MainActivity
import com.its.food.delivery.util.EMPLOYEE
import com.its.food.delivery.util.api.Resource
import com.its.food.delivery.util.errorDialog
import com.its.food.delivery.util.progressDialog
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LoginFragment :
    BaseFragment2<FragmentLoginBinding, LoginViewModel, LoginAndSignUpActivityViewModel>() {
    private var progressDialog: AlertDialog? = null
    private var errorDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        init()
        observe()
        return binding.root
    }

    private fun init() {
        lifecycle.addObserver(viewModel)
    }

    @SuppressLint("ResourceAsColor")
    private fun observe() {
        viewModel.navigateToMain.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let {
                val intent = Intent(this.context, MainActivity::class.java)
                startActivity(intent)
            }

        }

        viewModel.loginEvent.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let {
                val userName = binding.editTextTextEmailAddress.text.trim().toString()
                val password = binding.editTextTextPassword.text.trim().toString()
                if (userName.isEmpty() || userName == "") {
                    binding.tvValidateEmail.text = "*"
//                    binding.tvValidatePass.setTextColor(R.color.primaryColor)
                }
                if (password.isEmpty() || password == "") {
                    binding.tvValidatePass.text = "*"
                } else {
                    binding.tvValidateEmail.text = ""
                    binding.tvValidatePass.text = ""
                    processLogin(userName, password)
                }

//                "username" : "user1@gmail.com",
//                "password" : "123456"

            }
        }
    }

    @SuppressLint("NewApi")
    private fun processLogin(userName: String, password: String) {


        viewModel.login(userName, password).observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    Timber.d("Loading data: ${resource.cachedData?.toString()}")

                    progressDialog?.show()
                }
                is Resource.Error -> {
                    Timber.d("Error: ${resource.cachedData?.toString()} with code: ${resource.code}")

                    progressDialog?.dismiss()

                    errorDialog = errorDialog(
                        requireActivity(),
                        resource.code.name,
                        getString(R.string.error_message),
                        R.color.darkColor,
                        positiveClick = {
                            errorDialog?.dismiss()
                        }
                    )
                    errorDialog?.show()
                }

                is Resource.Success -> {

                    // Hide progress dialog
                    progressDialog?.dismiss()

                    val result = resource.data.result

                    Timber.d("result: ${resource.data.toString()}")

                    if (result) {
                        val role = resource.data?.data?.role ?: EMPLOYEE
                        val userId = resource.data?.data?.userId ?: ""
                        val token = resource.data?.data?.token ?: ""

                        // Save login success
                        viewModel.saveLogin(true, role, userId, token)
                        viewModel.navigateToMain()
                    } else {
                        // Show error dialog
                        errorDialog = errorDialog(
                            requireActivity(),
                            resource.data.error ?: "",
                            getString(R.string.error_title_error),
                            R.color.darkColor,
                            positiveClick = {
                                errorDialog?.dismiss()
                            }
                        )
                        errorDialog?.show()
                    }
                }
            }
        }
    }
}