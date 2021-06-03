package com.its.food.delivery.ui.login_and_sign_up.fragment

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.its.food.delivery.R
import com.its.food.delivery.databinding.FragmentSignUpBinding
import com.its.food.delivery.entity.Account
import com.its.food.delivery.ui.BaseFragment2
import com.its.food.delivery.ui.login_and_sign_up.LoginAndSignUpActivityViewModel
import com.its.food.delivery.util.errorDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login_and_signup.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@AndroidEntryPoint
class SignUpFragment :
    BaseFragment2<FragmentSignUpBinding, SignUpViewModel, LoginAndSignUpActivityViewModel>() {
    private var listAccount = ArrayList<Account>()
    private var errorDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel


        observe()


        return binding.root
    }

    private fun observe() {
        val pass1 = binding.edtPassword.text.trim().toString()
        val pass2 = binding.edtConfirmPass.text.trim().toString()
        val fullName = binding.edtFullName.text.trim().toString()
        val birthDay = binding.edtBirthDay.text.trim().toString()
        val email = binding.edtEmail.text.trim().toString()

        viewModel.navigateToCreate.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled().let {

                if (pass1 == pass2 && pass1.isNotEmpty()) {
                    listAccount.add(Account(fullName, birthDay, email, pass1))
                } else {
                    errorDialog = errorDialog(
                        requireActivity(),
                        "Create Account fail",
                        getString(R.string.error_title_error),
                        R.color.primaryColor,
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