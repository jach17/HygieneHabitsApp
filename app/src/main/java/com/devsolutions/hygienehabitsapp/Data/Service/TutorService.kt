package com.devsolutions.hygienehabitsapp.Data.Service

import com.devsolutions.hygienehabitsapp.Core.RetrofitHelper
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.DefaultResponse
import com.devsolutions.hygienehabitsapp.Data.Network.TutorApiClient
import retrofit2.Response

class TutorService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllTutors(): Response<DefaultResponse> {
       /* return withContext(Dispatchers.IO){
            val response = retrofit.create(TutorApiClient::class.java).getAllTutors()
            response
        }*/
        val response = retrofit.create(TutorApiClient::class.java).getAllTutors()

        return response

    }
}