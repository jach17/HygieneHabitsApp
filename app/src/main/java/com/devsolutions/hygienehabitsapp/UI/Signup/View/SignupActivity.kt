package com.devsolutions.hygienehabitsapp.UI.Signup.View

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
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
        signupViewModel.idCreated.observe(this, Observer {
            binding.progressBarSignup.apply {
                visibility = View.GONE
                
            }

            if(it!=0){
                Toast.makeText(this, "Created account", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Not created account", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initListeners() {
        binding.btnRegistrar.setOnClickListener { crearCuenta(binding.tietUsername.text.toString(),binding.tietUserage.text.toString(), binding.tietPassword.text.toString(), binding.tietConfirmPassword.text.toString()) }
        binding.btnGoToLogin.setOnClickListener { navigateToActivity(applicationContext, MainActivity::class.java) }
    }

    private fun crearCuenta(username: String, age: String, password: String, confirmPassword: String) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
        binding.progressBarSignup.apply {
            visibility = View.VISIBLE
        }

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