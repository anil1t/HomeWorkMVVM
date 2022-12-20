package com.imaginato.homeworkmvvm.ui.login

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.imaginato.homeworkmvvm.R
import com.imaginato.homeworkmvvm.databinding.ActivityLoginBinding
import com.imaginato.homeworkmvvm.exts.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActLogin : AppCompatActivity(), View.OnClickListener {

    private val loginViewModel by viewModels<LoginViewModel>()
    private lateinit var binding: ActivityLoginBinding
    private lateinit var networkHelper: NetworkHelper
    lateinit var customProgressDialog: CustomProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        setClickListener()
        initObserveData()

    }
    private fun setClickListener() {

        binding.btnLogin.setOnClickListener(this)

    }

    private fun initData() {
        customProgressDialog = CustomProgressDialog(this@ActLogin)
        networkHelper = NetworkHelper(this@ActLogin)
    }
    private fun initObserveData() {
        try {

            // for observe activity and get live updates
            loginViewModel.loginData.observe(this) {
                when (it.status) {

                    // get success status and go for next step
                    Status.SUCCESS -> {
                        try {
                            it.data?.let { model ->
                                if (model.LoginResultData!=null) {
                                    if (customProgressDialog != null && customProgressDialog.isShowing) {
                                        customProgressDialog.dismiss()
                                    }
                                } else {
                                    if (customProgressDialog != null && customProgressDialog.isShowing) {
                                        customProgressDialog.dismiss()
                                    }
                                }
                            }
                            it.message?.let { model ->

                                    if (customProgressDialog != null && customProgressDialog.isShowing) {
                                        customProgressDialog.dismiss()
                                    }

                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    // when getting data from server dialog display for please wait data is loading
                    Status.LOADING -> {
                        if (customProgressDialog != null && !customProgressDialog.isShowing) {
                            customProgressDialog.show()
                        }
                    }
                    // when getting null or something worng that time this status call
                    Status.ERROR -> {
                        if (customProgressDialog != null && customProgressDialog.isShowing) {
                            customProgressDialog.dismiss()
                        }
                        Extention.showSnackBarWithoutAction(this, "${it.message}", binding.root)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onClick(view: View?) {

        when (view!!.id) {

            R.id.btnLogin -> {

                when {
                    // checking username and password is null or empty or not
                    binding.edusername.text.toString().trim { it <= ' ' } == "" -> {
                        Extention.showSnackBarWithoutAction(
                                this@ActLogin,
                                resources.getString(R.string.enterusername) ,binding.edusername
                        )
                        binding.edusername.requestFocus()
                    }
                    binding.etpassword.text.toString().trim { it <= ' ' } == "" -> {

                        Extention.showSnackBarWithoutAction(
                            this@ActLogin,
                            resources.getString(R.string.enterpassword),
                            binding.etpassword
                        )
                        binding.etpassword.requestFocus()
                    }
                    else -> {
                        try {
                            // call Login api with username and password
                            loginViewModel.callLoginAPI( binding.edusername.text.toString(),binding.etpassword.text.toString())

                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }

        }
    }
}