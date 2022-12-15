package com.devsolutions.hygienehabitsapp.Data.Service

import com.devsolutions.hygienehabitsapp.Core.RetrofitHelper
import com.devsolutions.hygienehabitsapp.Core.SharedApp.Companion.prefs
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AuthUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.AddResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.AuthResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.DefaultResponse
import com.devsolutions.hygienehabitsapp.Data.Network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class TutorService {
    private val api = RetrofitHelper.getRetrofit().create(ApiClient::class.java)

    suspend fun getAllTutors():Response<DefaultResponse> {
        return withContext(Dispatchers.IO){
            val response = api.getAllTutors()
            response
        }
    }

    suspend fun authUser(body:AuthUserDto): Response<AuthResponse>? {
        return withContext(Dispatchers.IO){
            var response:Response<AuthResponse>?
            try{
                response = api.authUser(body)
                val response_info = api.getTutorId(body).body()?.message?.response
                prefs.tutorId=response_info?.get(0)?.idTutor
                prefs.tutorToken=response_info?.get(0)?.authTokenTutor
                println("Sale por acá")
                response
            }catch(e:Exception){
                response= null
                //For local working
                prefs.tutorId=1
                println("Sale pero de este lado men, con error: ${e.message}")
                response
            }


        }
    }
    suspend fun addUser(body: AddUserDto): Response<AddResponse> {
        return withContext(Dispatchers.IO){

            val response = api.addUser(body)
            response
        }
    }

    suspend fun getTutorById(id:Int): Response<DefaultResponse> {
        return withContext(Dispatchers.IO){
            val response = api.getTutorById(id)
            response
        }
    }


}