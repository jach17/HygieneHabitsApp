package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MessageSuccessListPlayersResponse
import com.google.gson.annotations.SerializedName

data class ListPlayersResponse(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MessageSuccessListPlayersResponse,
    @SerializedName("code")
    val code:String
    )
