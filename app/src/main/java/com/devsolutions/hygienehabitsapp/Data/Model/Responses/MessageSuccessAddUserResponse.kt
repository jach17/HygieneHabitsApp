package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.InsertedModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.RegistredModel
import com.google.gson.annotations.SerializedName

data class MessageSuccessAddUserResponse(
    @SerializedName("response")
    val response:ArrayList<InsertedModel>
)
