package com.devsolutions.hygienehabitsapp.UI.Signup.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Domain.TutorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupViewModel:ViewModel() {
    private val tutorUseCase = TutorUseCase()

    fun crearCuenta(username: String, age: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val id = tutorUseCase.crearCuenta(username, age, password)
            println("Id created: $id")
        }
    }

}