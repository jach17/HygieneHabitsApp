package com.devsolutions.hygienehabitsapp.Domain

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.Data.Repository.JugadorRepository

class JugadorUseCase {
    private val repository = JugadorRepository()
    suspend fun getReportsFromPlayerId(id:Int): ArrayList<ReporteModel> {
        return repository.getReportsFromPlayerId(id)
    }
    suspend fun getPlayersFromTutorId(id:Int): ArrayList<JugadorModel> {
        return repository.getPlayersFromTutorId(id)
    }
}