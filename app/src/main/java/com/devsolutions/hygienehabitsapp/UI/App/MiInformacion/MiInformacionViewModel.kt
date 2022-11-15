package com.devsolutions.hygienehabitsapp.UI.App.MiInformacion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.TutorModel
import com.devsolutions.hygienehabitsapp.Domain.TutorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MiInformacionViewModel:ViewModel() {
    val tutorUseCase = TutorUseCase()
    val tutorInfo = MutableLiveData<TutorModel>()

    fun getTutorInfoById(tutorId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            tutorInfo.postValue(tutorUseCase.getTutorById(tutorId))
        }
    }
}