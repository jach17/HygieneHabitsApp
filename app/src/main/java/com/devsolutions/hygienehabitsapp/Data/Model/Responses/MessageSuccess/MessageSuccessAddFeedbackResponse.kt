package com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.InsertedModel
import com.google.gson.annotations.SerializedName

data class MessageSuccessAddFeedbackResponse(
    @SerializedName("response")
    val response:ArrayList<InsertedModel>
    )
