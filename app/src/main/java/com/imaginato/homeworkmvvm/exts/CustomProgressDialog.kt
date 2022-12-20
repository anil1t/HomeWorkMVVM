package com.imaginato.homeworkmvvm.exts

import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import android.graphics.LightingColorFilter
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.KeyEvent
import android.view.View
import android.view.Window
import com.imaginato.homeworkmvvm.R
import java.lang.Exception

class CustomProgressDialog(context: Context) : Dialog(context) {
    var mProgressBar: ProgressBar
    fun setMessage(message: String?) {}

    init {
        window!!.setLayout(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.progressbar)
        setCancelable(false)
        mProgressBar = findViewById<View>(R.id.progressBar) as ProgressBar

        val mul = 0x00000000 //Transparent
        val add = 0x436EFE //Blue

        try {
            mProgressBar.indeterminateDrawable.colorFilter = LightingColorFilter(mul, add)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        setOnKeyListener { arg, keyCode, event -> // TODO Auto-generated method stub
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                dismiss()
                (context as Activity).finish()
            }
            true
        }
    }
}