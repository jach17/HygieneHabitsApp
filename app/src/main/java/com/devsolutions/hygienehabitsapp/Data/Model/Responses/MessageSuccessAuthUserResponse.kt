package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.RegistredModel
import com.google.gson.annotations.SerializedName

data class MessageSuccessAuthUserResponse(
    @SerializedName("response")
    val response:ArrayList<RegistredModel>
)