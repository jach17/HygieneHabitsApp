package com.devsolutions.hygienehabitsapp.Data.Network

import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AuthUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.InsertedModel
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiClient {
    @GET("list/tutors")
    suspend fun getAllTutors(): Response<DefaultResponse>

    @GET("list/reports/player/{id}")
    suspend fun getReportsFromPlayerId(@Path("id") id:Int):Response<ListReportsResponse>

    @GET("list/sesions/player/{id}")
    suspend fun getSessionsFromPlayerId(@Path("id") id:Int):Response<ListSessionsResponse>

    @POST("auth/tutor")
    suspend fun authUser(@Body authUserDto: AuthUserDto): Response<AuthResponse>

    @POST("add/tutor")
    suspend fun addUser(@Body addUserDto: AddUserDto):Response<AddResponse>

    @GET("list/player/tutor/{id}")
    suspend fun getPlayerByTutorId(@Path("id") id: Int):Response<ListPlayersResponse>

    @POST("list/tutor/id")
    suspend fun getTutorId(@Body authUserDto: AuthUserDto): Response<TutorIdResponse>

    @GET("list/player/{id}")
    suspend fun getPlayersById(@Path("id")id: Int): Response<ListPlayersResponse>
}