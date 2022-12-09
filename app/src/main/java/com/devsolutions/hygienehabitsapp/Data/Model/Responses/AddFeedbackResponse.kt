package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MessageSuccessAddFeedbackResponse
import com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess.MessageSuccessAddUserResponse
import com.google.gson.annotations.SerializedName

data class AddFeedbackResponse(
    @SerializedName("result")
    val result:String,
    @SerializedName("message")
    val message: MessageSuccessAddFeedbackResponse,
    @SerializedName("code")
    val code:String
)
