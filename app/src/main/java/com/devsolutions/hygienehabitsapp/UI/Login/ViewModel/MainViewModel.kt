package com.devsolutions.hygienehabitsapp.UI.Login.ViewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.devsolutions.hygienehabitsapp.Core.SharedApp.Companion.prefs
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.TutorModel
import com.devsolutions.hygienehabitsapp.Domain.TutorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val tutorList = MutableLiveData<List<TutorModel>>()
    var tutorUseCase = TutorUseCase()
    var isLogged = MutableLiveData<Boolean>()



    fun authUser(user: String, password: String) {
        viewModelScope.launch (Dispatchers.IO){
            if(tutorUseCase.authUser(user, password)){
                isLogged.postValue(true)
            }else{
                isLogged.postValue(false)
            }
        }
    }



}