package com.its.food.delivery.util

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.its.food.delivery.R
import com.its.food.delivery.ui.appContext
import kotlinx.android.synthetic.main.dialog_error.view.*
import kotlinx.android.synthetic.main.dialog_progress.view.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun progressDialog(
    context: Activity,
    message: String,
): AlertDialog {
    val contentView: View = context.layoutInflater.inflate(R.layout.dialog_progress, null)
    contentView.txtMessage.text = message

    MaterialAlertDialogBuilder(context)
        .setView(contentView)
        .create()
        .apply {
            setCanceledOnTouchOutside(false)
            setCancelable(false)
            window?.setBackgroundDrawable(context.getDrawable(R.drawable.background_dialog))
            return this
        }
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun errorDialog(
    context: Activity,
    message: String,
    title: String,
    color: Int,
    positiveClick: (() -> Unit)

): AlertDialog {
    val contentView: View = context.layoutInflater.inflate(R.layout.dialog_error, null)
    contentView.tvTitleError.text = title
    contentView.tvMessageError.text = message
    contentView.backgroundDialogError.setCardBackgroundColor(ContextCompat.getColor(appContext,color))
    contentView.btnErrorOk.setOnClickListener{
        positiveClick.invoke()
    }
    MaterialAlertDialogBuilder(context)
        .setView(contentView)
        .create()
        .apply {
            setCanceledOnTouchOutside(false)
            setCancelable(false)
            window?.setBackgroundDrawable(context.getDrawable(R.drawable.background_dialog))
            return this
        }
}



