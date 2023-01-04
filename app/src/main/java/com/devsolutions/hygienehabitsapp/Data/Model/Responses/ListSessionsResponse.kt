package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MesssageSuccessListReportsResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MesssageSuccessListSessionsResponse
import com.google.gson.annotations.SerializedName

data class ListSessionsResponse(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MesssageSuccessListSessionsResponse,
    @SerializedName("code")
    val code:String
)
