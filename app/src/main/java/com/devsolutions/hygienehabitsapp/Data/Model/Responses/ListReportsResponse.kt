package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MesssageSuccessListReportsResponse
import com.google.gson.annotations.SerializedName

data class ListReportsResponse(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MesssageSuccessListReportsResponse,
    @SerializedName("code")
    val code:String
)
