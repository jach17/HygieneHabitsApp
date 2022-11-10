package com.devsolutions.hygienehabitsapp.Data.Repository

import com.devsolutions.hygienehabitsapp.Data.Service.JugadorService

class JugadorRepository {
    private val api = JugadorService()

    suspend fun getReportsFromPlayerId(id: Int) {
        val response = api.getReportsFromPlayerId(id)
        println("Response: ${response.body()?.message?.response}")

    }
}