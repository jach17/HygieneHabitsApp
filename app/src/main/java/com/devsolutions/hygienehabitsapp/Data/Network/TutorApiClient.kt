package com.devsolutions.hygienehabitsapp.Data.Network

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.DefaultResponse
import retrofit2.Response
import retrofit2.http.GET

interface TutorApiClient {
    @GET("list/tutors")
    suspend fun getAllTutors(): Response<DefaultResponse>

}