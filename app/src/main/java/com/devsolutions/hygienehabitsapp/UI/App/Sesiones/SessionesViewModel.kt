package com.devsolutions.hygienehabitsapp.UI.App.Sesiones

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.FullReportFromSessionModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.SessionModel
import com.devsolutions.hygienehabitsapp.Domain.JugadorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SessionesViewModel:ViewModel() {
    val jugadorUseCase=JugadorUseCase()
    val sessionsList = MutableLiveData<ArrayList<SessionModel>>()
    val listReportsBySession = MutableLiveData<ArrayList<FullReportFromSessionModel>>()


    fun getSessionsFromPlayerId(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            sessionsList.postValue(jugadorUseCase.getSessionsFromPlayerId(id))
        }
    }
    fun getReportsFromSessionId(sessionId:Int){
        viewModelScope.launch(Dispatchers.IO) {
            listReportsBySession.postValue(jugadorUseCase.getFullReportsFromSessionId(sessionId))
        }
    }

    fun getListReportsBySession(): ArrayList<FullReportFromSessionModel> {
        return listReportsBySession.value!!
    }
}