package com.imaginato.homeworkmvvm.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LoginModel(

    @SerializedName("errorMessage") var errorMessage: String? = null,
    @SerializedName("errorCode") var errorCode: String? = null,
    @SerializedName("data") var LoginResultData: Data? = null
)

data class Data(
    @SerializedName("userId") val userId: String,
    @SerializedName("userName") val userName: String,
    @SerializedName("isDeleted") val isDeleted: Boolean,
    @SerializedName("X-Acc") var x_Acc: String

)
