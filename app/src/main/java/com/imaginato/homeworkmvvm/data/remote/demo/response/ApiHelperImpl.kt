package com.imaginato.homeworkmvvm.data.remote.demo.response


import com.imaginato.homeworkmvvm.data.model.LoginModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getLogin(
        userName: String,
        password: String
    ): Response<LoginModel> =
        apiService.getLoginAPI(userName, password)
}
