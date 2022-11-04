package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.google.gson.annotations.SerializedName

data class MessageSuccessResponse(
    @SerializedName("response")
    val response:ArrayList<TutorResponse>
)