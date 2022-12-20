package com.imaginato.homeworkmvvm.exts

import android.util.Log

object LogM {

    fun LogV(Message: String) {
            Log.v("LogV : ", Message);

    }
    fun LogI(Message: String) {
            Log.i("LogI : ", Message)

    }
    fun LogE(tag: String, msg: String, response: String) {
            Log.e(tag, msg + response)

    }
    fun LogError(callLoginAPI: String, message: String) {
            Log.e(callLoginAPI, message);

    }

}