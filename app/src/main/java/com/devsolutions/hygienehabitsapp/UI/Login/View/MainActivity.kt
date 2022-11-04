package com.devsolutions.hygienehabitsapp.UI.Login.View

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.devsolutions.hygienehabitsapp.UI.Login.ViewModel.MainViewModel
import com.devsolutions.hygienehabitsapp.UI.Signup.View.SignupActivity
import com.devsolutions.hygienehabitsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = MainViewModel()
        setContentView(binding.root)
        initListeners()
        mainViewModel.getAllTutors()

        mainViewModel.tutorList.observe(this, Observer {
            println("C A M B I O ")
            println(it)
        })


    }

    private fun initListeners() {
        binding.btnGoToSignup.setOnClickListener { navigateToActivity(applicationContext, SignupActivity::class.java) }
        binding.btnIngresar.setOnClickListener { authUser(binding.tietUsername.text.toString(), binding.tietPassword.text.toString()) }

    }

    private fun authUser(user: String, password: String) {
        mainViewModel.getAllTutors()
    }

    private fun navigateToActivity(context: Context, destine: Class<*>) {
        val intent = Intent(context, destine)
        startActivity(intent)
    }
}