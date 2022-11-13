package com.devsolutions.hygienehabitsapp.UI.App.Niveles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.Domain.JugadorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NivelesViewModel:ViewModel() {
    val jugadorUseCase = JugadorUseCase()
    val listReports = MutableLiveData<ArrayList<ReporteModel>>()

    fun getReportsFromPlayerId(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            listReports.postValue(jugadorUseCase.getReportsFromPlayerId(id))
        }

    }
}