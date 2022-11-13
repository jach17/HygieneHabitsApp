package com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.IdTutorModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.RegistredModel
import com.google.gson.annotations.SerializedName

data class MessageSuccessIdTutor(
    @SerializedName("response")
    val response:ArrayList<IdTutorModel>
)
