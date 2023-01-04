package com.devsolutions.hygienehabitsapp.UI.App.DetallesReportes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Domain.JugadorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailReportViewModel:ViewModel() {
    private val jugadorUseCase = JugadorUseCase()
    val result = MutableLiveData<Int>()


    fun addTutorFeedbackOnReport(reportId:Int, feedback:String){
        viewModelScope.launch(Dispatchers.IO) {
            val res = jugadorUseCase.addTutorFeedbackOnReport(reportId, feedback)
            result.postValue(res)
        }
    }
}