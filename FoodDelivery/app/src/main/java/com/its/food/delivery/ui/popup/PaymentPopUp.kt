package com.its.food.delivery.ui.popup

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import androidx.databinding.DataBindingUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.its.food.delivery.R
import com.its.food.delivery.databinding.PopupPaymentBinding
import com.its.food.delivery.ui.ActivityBaseDialogFragment
import com.its.food.delivery.ui.checkout.CheckOutViewModel
import com.its.food.delivery.ui.checkout_payment.CheckOutPaymentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PaymentPopUp :
    ActivityBaseDialogFragment<PopupPaymentBinding, PaymentPopUpViewModel, CheckOutPaymentViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.closeClick.observe(this) { event ->
            event.getContentIfNotHandled()?.takeIf { it }?.let {
                dismiss()
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        binding =
            DataBindingUtil.inflate(inflater, R.layout.popup_payment, null, false)
        binding.viewModel = this.viewModel
        binding.lifecycleOwner = this

        val dialog =
            MaterialAlertDialogBuilder(requireContext())
                .setView(binding.root)
                .create()

        dialog.setCanceledOnTouchOutside(false)

        dialog.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                viewModel.keyCodeBack()
                true
            } else {
                false
            }
        }

        return dialog
    }

    override fun onDismiss(dialog: DialogInterface) {
        val vm = activityViewModel
        GlobalScope.launch {
            delay(500)
            vm.callPopupClose()
        }
        super.onDismiss(dialog)
    }
}