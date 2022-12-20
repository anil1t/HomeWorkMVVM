package com.design.crmtigerrestructure.data.repository

import com.imaginato.homeworkmvvm.data.remote.demo.response.ApiHelper
import javax.inject.Inject

class MainAppRepository @Inject constructor(private val apiHelper: ApiHelper) {

    //Login API
    suspend fun getLogin(userName: String, password: String) = apiHelper.getLogin(userName, password)
}