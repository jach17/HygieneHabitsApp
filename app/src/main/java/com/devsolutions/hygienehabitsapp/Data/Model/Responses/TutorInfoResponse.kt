package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MessageSuccessInfoTutor
import com.google.gson.annotations.SerializedName

data class TutorInfoResponse(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MessageSuccessInfoTutor,
    @SerializedName("code")
    val code:String
)
