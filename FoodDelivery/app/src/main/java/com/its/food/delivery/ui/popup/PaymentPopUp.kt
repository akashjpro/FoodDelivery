package com.its.food.delivery.ui.popup

import android.app.Dialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.shape.Shapeable
import com.its.food.delivery.R
import com.its.food.delivery.adapters.PopupAdapter
import com.its.food.delivery.databinding.PopupPaymentBinding
import com.its.food.delivery.entity.Popup
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

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        binding =
            DataBindingUtil.inflate(inflater, R.layout.popup_payment, null, false)
        binding.viewModel = this.viewModel
        binding.lifecycleOwner = this

        binding.btnCancel.setOnClickListener {
            dialog?.dismiss()
        }

        val exampleListPopUp = mutableListOf<Popup>(
            Popup("1", "Delivery to Mainland", "N1000 - N2000"),
            Popup("1", "Delivery to Island", "N2000 - N3000"),
            Popup("1", "Delivery to Island", "N2000 - N5000")
        )

        val popupAdapter = PopupAdapter()
        popupAdapter.submitList(exampleListPopUp)
        binding.recyclerviewNoteFood.adapter = popupAdapter
        binding.recyclerviewNoteFood.layoutManager = LinearLayoutManager(context)

        val dialog =
            MaterialAlertDialogBuilder(requireContext())
                .setView(binding.root)
                .create()
                .apply {
                    setCanceledOnTouchOutside(false)
                    setCancelable(false)
                    window?.setBackgroundDrawable(context.getDrawable(R.drawable.background_dialog))
                }
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