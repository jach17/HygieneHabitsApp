package com.devsolutions.hygienehabitsapp.UI.App.Reportes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.ReportInfoDto
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.Domain.JugadorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReportesViewModel:ViewModel() {
    val jugadorUseCase = JugadorUseCase()
    val listReports = MutableLiveData<ArrayList<ReportInfoDto>>()
    val listReportsBySession = MutableLiveData<ArrayList<ReportInfoDto>>()


    fun getReportsFromSessionId(sessionId:Int){
        viewModelScope.launch(Dispatchers.IO) {
            listReportsBySession.postValue(jugadorUseCase.getFullReportsFromSessionId(sessionId))
        }
    }

    fun getReportsFromPlayerId(playerId:Int){
        viewModelScope.launch(Dispatchers.IO) {
            listReports.postValue(jugadorUseCase.getReportsFromPlayerId(playerId))
        }
    }


}