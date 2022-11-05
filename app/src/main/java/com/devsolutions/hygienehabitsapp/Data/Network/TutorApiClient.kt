package com.devsolutions.hygienehabitsapp.Data.Network

import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AuthUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.AddResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.AuthResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.DefaultResponse
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TutorApiClient {
    @GET("list/tutors")
    suspend fun getAllTutors(): Response<DefaultResponse>

    @POST("auth/tutor")
    suspend fun authUser(@Body authUserDto: AuthUserDto): Response<AuthResponse>

    @POST("add/tutor")
    suspend fun addUser(@Body addUserDto: AddUserDto):Response<AddResponse>
}