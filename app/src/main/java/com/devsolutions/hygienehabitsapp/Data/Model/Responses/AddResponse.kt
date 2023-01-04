package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MessageSuccessAddUserResponse
import com.google.gson.annotations.SerializedName

data class AddResponse(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MessageSuccessAddUserResponse,
    @SerializedName("code")
    val code:String
)
