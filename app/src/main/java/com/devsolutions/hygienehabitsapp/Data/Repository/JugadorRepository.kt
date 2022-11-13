package com.devsolutions.hygienehabitsapp.Data.Repository

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.Data.Service.JugadorService

class JugadorRepository {
    private val api = JugadorService()

    suspend fun getReportsFromPlayerId(id: Int): ArrayList<ReporteModel> {
        val response = api.getReportsFromPlayerId(id)
        val list= response.body()?.message?.response
        return list!!
    }

    suspend fun getPlayersFromTutorId(id:Int): ArrayList<JugadorModel> {
        val response = api.getPlayersByTutorId(id)
        val list = response.body()?.message?.response
        return list!!
    }
}