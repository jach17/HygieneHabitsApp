package com.devsolutions.hygienehabitsapp.Data.Service

import com.devsolutions.hygienehabitsapp.Core.RetrofitHelper
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.ListPlayersResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.ListReportsResponse
import com.devsolutions.hygienehabitsapp.Data.Network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class JugadorService {
    private val api = RetrofitHelper.getRetrofit().create(ApiClient::class.java)

    suspend fun getReportsFromPlayerId(id: Int): Response<ListReportsResponse> {
        return withContext(Dispatchers.IO){
            val response = api.getReportsFromPlayerId(id)
            response
        }
    }

    suspend fun getPlayersByTutorId(id:Int):Response<ListPlayersResponse>{
        return withContext(Dispatchers.IO){
            val response = api.getPlayerByTutorId(id)
            response
        }
    }

    suspend fun getPlayersById(id: Int): Response<ListPlayersResponse> {
        return withContext(Dispatchers.IO){
            val response = api.getPlayersById(id)
            response
        }
    }
}