package com.imaginato.homeworkmvvm.data.remote.demo.response

import retrofit2.Response
import com.imaginato.homeworkmvvm.data.model.LoginModel
import com.imaginato.homeworkmvvm.exts.WebField

import retrofit2.http.*

interface ApiService {

    @Headers("IMSI:357175048449937", "IMEI:510110406068589")
    @POST("api/login")
    @FormUrlEncoded
    suspend fun getLoginAPI(
        @Field(WebField.USERNAME) userName: String,
        @Field(WebField.PASSWORD) password: String
    ): Response<LoginModel>


}