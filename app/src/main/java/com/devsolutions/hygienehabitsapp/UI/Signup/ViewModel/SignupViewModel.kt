package com.devsolutions.hygienehabitsapp.UI.Signup.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Domain.TutorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupViewModel:ViewModel() {
    private val tutorUseCase = TutorUseCase()
    val idCreated = MutableLiveData<Int>()

    fun crearCuenta(username: String, age: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            idCreated.postValue(tutorUseCase.crearCuenta(username, age, password))
        }
    }

}