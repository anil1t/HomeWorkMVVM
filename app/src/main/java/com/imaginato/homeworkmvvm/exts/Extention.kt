package com.imaginato.homeworkmvvm.exts

import android.content.Context
import android.view.*
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.imaginato.homeworkmvvm.R

object Extention {

fun showSnackBarWithoutAction(context: Context, message: String, view: View) {
    try {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        snackbar.view.setBackgroundColor(ContextCompat.getColor(context, R.color.app_color))
        snackbar.show()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
}
