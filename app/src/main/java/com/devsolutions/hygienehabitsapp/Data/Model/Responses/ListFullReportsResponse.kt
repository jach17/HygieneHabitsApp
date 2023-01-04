package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MessageSuccessListFullReportsResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MesssageSuccessListReportsResponse
import com.google.gson.annotations.SerializedName

data class ListFullReportsResponse(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MessageSuccessListFullReportsResponse,
    @SerializedName("code")
    val code:String
)
