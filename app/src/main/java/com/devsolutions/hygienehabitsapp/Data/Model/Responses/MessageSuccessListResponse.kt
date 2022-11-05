package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.TutorModel
import com.google.gson.annotations.SerializedName

data class MessageSuccessListResponse(
    @SerializedName("response")
    val response:ArrayList<TutorModel>
)