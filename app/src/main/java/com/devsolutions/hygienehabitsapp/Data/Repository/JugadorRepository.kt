package com.devsolutions.hygienehabitsapp.Data.Repository

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Data.Service.JugadorService

class JugadorRepository {
    private val api = JugadorService()

    suspend fun getReportsFromPlayerId(id: Int) {
        val response = api.getReportsFromPlayerId(id)
        println("Response: ${response.body()?.message?.response}")
    }

    suspend fun getPlayersFromTutorId(id:Int): ArrayList<JugadorModel> {
        val response = api.getPlayersByTutorId(id)
        val list = response.body()?.message?.response
        return list!!
    }
}