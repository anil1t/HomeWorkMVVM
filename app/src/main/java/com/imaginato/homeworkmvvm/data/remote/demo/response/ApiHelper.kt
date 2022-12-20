package com.imaginato.homeworkmvvm.data.remote.demo.response

import retrofit2.Response
import com.imaginato.homeworkmvvm.data.model.LoginModel

interface ApiHelper {

    suspend fun getLogin(
        userName: String,
        password: String
    ): Response<LoginModel>
}