package com.imaginato.homeworkmvvm.ui.login

import android.app.Application
import com.design.crmtigerrestructure.data.repository.MainAppRepository
import com.imaginato.homeworkmvvm.R
import com.imaginato.homeworkmvvm.data.model.LoginModel
import com.imaginato.homeworkmvvm.exts.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception
import androidx.lifecycle.*
import com.imaginato.homeworkmvvm.data.local.userroomdata.UserData
import com.imaginato.homeworkmvvm.data.local.userroomdata.UserDatabase
import kotlinx.coroutines.GlobalScope

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: MainAppRepository,
    private val networkHelper: NetworkHelper,
    val application: Application
) : ViewModel() {


    // this _loginData variable for holding data model
    val _loginData = SingleLiveEvent<Resource<LoginModel>>()
    val loginData: SingleLiveEvent<Resource<LoginModel>> get() = _loginData

    // this for  declaring Database object
    lateinit var  database: UserDatabase

    fun callLoginAPI(strUsername: String, strPassword: String) {
        try {
            // this for view model scope to hold data where we got from serve
            viewModelScope.launch {
                try {
                    // set model null on livedata and then set value using postValue fun
                    _loginData.postValue(Resource.loading(null))

                    // this for internet checking availability in mobile
                    if (networkHelper.isNetworkConnected()) {
                            loginRepository.getLogin(
                                strUsername, strPassword).let {

                                if (it.isSuccessful) {
                                    // get database instance
                                    database= UserDatabase.getDataBase(application)

                                    // set value on live data where we got in it object
                                    _loginData.postValue(Resource.success(it.body()))

                                    val headers = it.headers()
                                    val headers_X_Acc = headers["X-Acc"]

                                    // set headers value on live data where we got in it object
                                    _loginData.postValue(Resource.header(headers_X_Acc.toString(),null))

                                    // call insert fun using database object and perform insert operation
                                    GlobalScope.launch {
                                        database.userDataDao().insertUserData(UserData(
                                            0,
                                            it.body()!!.LoginResultData!!.userId,
                                            it.body()!!.LoginResultData!!.userName,
                                            it.body()!!.LoginResultData!!.isDeleted,
                                            headers_X_Acc.toString()
                                        ))
                                    }

                                } else _loginData.postValue(
                                    Resource.error(
                                        it.errorBody().toString(), null
                                    )
                                )
                            }

                    } else _loginData.postValue(Resource.error(ConstVariable.NO_INTERNET, null))

                } catch (e: Exception) {
                    _loginData.postValue(Resource.error(application.applicationContext.getString(R.string.error_wrong),null))
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}