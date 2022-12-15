package com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.InfoTutorModel
import com.google.gson.annotations.SerializedName

data class MessageSuccessInfoTutor(
    @SerializedName("response")
    val response:ArrayList<InfoTutorModel>
)
