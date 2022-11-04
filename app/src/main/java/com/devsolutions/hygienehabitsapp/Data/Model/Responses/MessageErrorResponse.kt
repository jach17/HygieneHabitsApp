package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ErrorModel
import com.google.gson.annotations.SerializedName

data class MessageErrorResponse(
    @SerializedName("response")
    val response:ArrayList<ErrorModel>
)
