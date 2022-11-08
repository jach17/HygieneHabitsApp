package com.devsolutions.hygienehabitsapp.UI.Login.View

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivity
import com.devsolutions.hygienehabitsapp.UI.Login.ViewModel.MainViewModel
import com.devsolutions.hygienehabitsapp.UI.Signup.View.SignupActivity
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment
import com.devsolutions.hygienehabitsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private val splash = SplashFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = MainViewModel()
        setContentView(binding.root)
        initListeners()
        mainViewModel.isLogged.observe(this, Observer {
            splash.dismiss()
            if(it){
                navigateToActivity(this, HomeActivity::class.java)
            }
        })
    }

    private fun initListeners() {
        binding.btnGoToSignup.setOnClickListener { navigateToActivity(applicationContext, SignupActivity::class.java) }
        binding.btnIngresar.setOnClickListener { authUser(binding.tietUsername.text.toString(), binding.tietPassword.text.toString()) }

    }

    private fun authUser(user: String, password: String) {
        splash.show(this.supportFragmentManager, "SPLASH")
        mainViewModel.authUser(user, password)
    }

    private fun navigateToActivity(context: Context, destine: Class<*>) {
        val intent = Intent(context, destine)
        startActivity(intent)
    }
}