package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MessageSuccessAddUserResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MessageSuccessIdTutor
import com.google.gson.annotations.SerializedName

data class TutorIdResponse(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MessageSuccessIdTutor,
    @SerializedName("code")
    val code:String
)
