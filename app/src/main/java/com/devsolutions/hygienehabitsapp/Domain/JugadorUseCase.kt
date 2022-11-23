package com.devsolutions.hygienehabitsapp.Domain

import com.devsolutions.hygienehabitsapp.Data.Model.Dto.ReportInfoDto
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.SessionModel
import com.devsolutions.hygienehabitsapp.Data.Repository.JugadorRepository

class JugadorUseCase {
    private val repository = JugadorRepository()

    suspend fun getFullReportsFromSessionId(sessionId:Int): ArrayList<ReportInfoDto> {
        return repository.getFullReportsFromSessionId(sessionId)
    }

    suspend fun getReportsFromPlayerId(id:Int): ArrayList<ReportInfoDto> {
        return repository.getReportsFromPlayerId(id)
    }
    suspend fun getPlayersFromTutorId(id:Int): ArrayList<JugadorModel> {
        return repository.getPlayersFromTutorId(id)
    }

    suspend fun getPlayersById(id: Int): JugadorModel? {
        return repository.getPlayerById(id)
    }
    suspend fun getSessionsFromPlayerId(id: Int):ArrayList<SessionModel>{
        return  repository.getSessionsFromPlayerId(id)
    }
}