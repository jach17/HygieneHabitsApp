package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MessageSuccessAuthUserResponse,
    @SerializedName("code")
    val code:String
)
