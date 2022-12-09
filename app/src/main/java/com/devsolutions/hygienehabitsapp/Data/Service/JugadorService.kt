package com.devsolutions.hygienehabitsapp.Data.Service

import com.devsolutions.hygienehabitsapp.Core.RetrofitHelper
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddFeedbackDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.*
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

    suspend fun getSessionsFromPlayerId(id: Int): Response<ListSessionsResponse> {
        return withContext(Dispatchers.IO){
            val response = api.getSessionsFromPlayerId(id)
            response
        }
    }

    suspend fun getFullReportsFromPlayerId(id:Int):Response<ListFullReportsResponse>{
        return withContext(Dispatchers.IO){
            val response = api.getFullReportsFromPlayerId(id)
            response
        }
    }
    suspend fun addTutorFeedback(reportId:Int, body: AddFeedbackDto): Response<AddFeedbackResponse> {
        return withContext(Dispatchers.IO){
            val response = api.addTutorFeedbackOnReport(reportId, body)
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