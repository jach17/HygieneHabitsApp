package com.devsolutions.hygienehabitsapp.UI.Login.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.TutorModel
import com.devsolutions.hygienehabitsapp.Domain.TutorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val tutorList = MutableLiveData<List<TutorModel>>()
    var tutorUseCase = TutorUseCase()



    fun getAllTutors(){
        viewModelScope.launch(Dispatchers.IO) {
            tutorList.postValue(tutorUseCase.getAllTutor())
        }
    }
}