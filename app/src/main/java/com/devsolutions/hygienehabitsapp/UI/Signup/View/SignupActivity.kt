package com.devsolutions.hygienehabitsapp.UI.Signup.View

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.devsolutions.hygienehabitsapp.UI.Login.View.MainActivity
import com.devsolutions.hygienehabitsapp.UI.Signup.ViewModel.SignupViewModel
import com.devsolutions.hygienehabitsapp.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignupBinding
    private lateinit var signupViewModel:SignupViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        signupViewModel = SignupViewModel()
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.btnRegistrar.setOnClickListener { crearCuenta(binding.tietUsername.text.toString(),binding.tietUserage.text.toString(), binding.tietPassword.text.toString(), binding.tietConfirmPassword.text.toString()) }
        binding.btnGoToLogin.setOnClickListener { navigateToActivity(applicationContext, MainActivity::class.java) }
    }

    private fun crearCuenta(username: String, age: String, password: String, confirmPassword: String) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
        if(password.equals(confirmPassword)){
            println("DE aqui")
            signupViewModel.crearCuenta(username, age, password)
        }else{
            println("De aca pue")
        }


    }

    private fun navigateToActivity(context: Context, destine: Class<*>) {
        val intent = Intent(context, destine)
        startActivity(intent)
    }
}