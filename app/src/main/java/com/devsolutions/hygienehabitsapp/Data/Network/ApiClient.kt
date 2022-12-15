package com.devsolutions.hygienehabitsapp.Data.Network

import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddFeedbackDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AuthUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiClient {
    @GET("list/tutors")
    suspend fun getAllTutors(): Response<DefaultResponse>

    @GET("list/tutor/{id}")
    suspend fun getTutorById(@Path("id") id: Int): Response<DefaultResponse>

    @GET("list/reports/player/{id}")
    suspend fun getReportsFromPlayerId(@Path("id") id:Int):Response<ListReportsResponse>

    @GET("list/fullreports/player/{id}")
    suspend fun getFullReportsFromPlayerId(@Path("id") id:Int):Response<ListFullReportsResponse>

    @GET("list/sesions/player/{id}")
    suspend fun getSessionsFromPlayerId(@Path("id") id:Int):Response<ListSessionsResponse>

    @POST("add/feedback/report/{id}")
    suspend fun addTutorFeedbackOnReport(@Path("id") id:Int, @Body addFeedbackDto: AddFeedbackDto):Response <AddFeedbackResponse>

    @POST("auth/tutor")
    suspend fun authUser(@Body authUserDto: AuthUserDto): Response<AuthResponse>

    @POST("add/tutor")
    suspend fun addUser(@Body addUserDto: AddUserDto):Response<AddResponse>

    @GET("list/player/tutor/{id}")
    suspend fun getPlayerByTutorId(@Path("id") id: Int):Response<ListPlayersResponse>

    @POST("list/tutor/id")
    suspend fun getTutorId(@Body authUserDto: AuthUserDto): Response<TutorInfoResponse>

    @GET("list/player/{id}")
    suspend fun getPlayersById(@Path("id")id: Int): Response<ListPlayersResponse>


}