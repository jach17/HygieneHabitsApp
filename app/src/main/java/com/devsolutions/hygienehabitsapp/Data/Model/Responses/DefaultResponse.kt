package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MessageSuccessListResponse
import com.google.gson.annotations.SerializedName

data class DefaultResponse (
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MessageSuccessListResponse,
    @SerializedName("code")
    val code:String
)