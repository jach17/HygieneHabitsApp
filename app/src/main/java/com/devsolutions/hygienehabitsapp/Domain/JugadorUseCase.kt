package com.devsolutions.hygienehabitsapp.Domain

import com.devsolutions.hygienehabitsapp.Data.Repository.JugadorRepository

class JugadorUseCase {
    private val repository = JugadorRepository()
    suspend fun getReportsFromPlayerId(id:Int){
        return repository.getReportsFromPlayerId(id)
    }
}