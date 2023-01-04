package com.devsolutions.hygienehabitsapp.UI.Login.View

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Core.SharedApp.Companion.prefs
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivity
import com.devsolutions.hygienehabitsapp.UI.Error.OnErrorFragment
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
        initObservables()
        initView()
        initListeners()
        isSessionLogged()
    }

    private fun initObservables() {
        mainViewModel.isLogged.observe(this, Observer {
            splash.dismiss()
            if (it) {
                prefs.isLogged = true
                navigateToActivity(this, HomeActivity::class.java)
                this.finish()
            } else {
                val error_screen = OnErrorFragment(getString(R.string.error_on_login))
                error_screen.show(supportFragmentManager, "ERROR")
            }
        })
    }

    private fun initView() {
        splash.show(this.supportFragmentManager, getString(R.string.splash))
    }

    private fun isSessionLogged() {
        splash.dismiss()
        if (prefs.isLogged!!) {
            navigateToActivity(this, HomeActivity::class.java)
            finish()
        }
    }

    private fun initListeners() {
        binding.btnGoToSignup.setOnClickListener {
            navigateToActivity(
                applicationContext,
                SignupActivity::class.java
            )
        }
        binding.btnIngresar.setOnClickListener {
            authUser(
                binding.tietUsername.text.toString(),
                binding.tietPassword.text.toString()
            )
        }
    }

    private fun authUser(user: String, password: String) {
        splash.show(this.supportFragmentManager, getString(R.string.splash))
        mainViewModel.authUser(user, password)
    }

    private fun navigateToActivity(context: Context, destine: Class<*>) {
        val intent = Intent(context, destine)
        startActivity(intent)
    }
}