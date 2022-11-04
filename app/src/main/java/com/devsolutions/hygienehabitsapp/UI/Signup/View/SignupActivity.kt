package com.devsolutions.hygienehabitsapp.UI.Signup.View

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devsolutions.hygienehabitsapp.UI.Login.View.MainActivity
import com.devsolutions.hygienehabitsapp.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.btnGoToLogin.setOnClickListener { navigateToActivity(applicationContext, MainActivity::class.java) }
    }

    private fun navigateToActivity(context: Context, destine: Class<*>) {
        val intent = Intent(context, destine)
        startActivity(intent)
    }
}