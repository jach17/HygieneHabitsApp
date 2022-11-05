package com.devsolutions.hygienehabitsapp.Data.Service

import com.devsolutions.hygienehabitsapp.Core.RetrofitHelper
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AuthUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.AddResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.AuthResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.DefaultResponse
import com.devsolutions.hygienehabitsapp.Data.Network.TutorApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response

class TutorService {
    private val api = RetrofitHelper.getRetrofit().create(TutorApiClient::class.java)

    suspend fun getAllTutors():Response<DefaultResponse> {
        return withContext(Dispatchers.IO){
            val response = api.getAllTutors()
            response
        }
    }

    suspend fun authUser(body:AuthUserDto): Response<AuthResponse> {
        return withContext(Dispatchers.IO){

            val response = api.authUser(body)
            response
        }
    }
    suspend fun addUser(body: AddUserDto): Response<AddResponse> {
        return withContext(Dispatchers.IO){

            val response = api.addUser(body)
            response
        }
    }
}