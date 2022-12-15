package com.devsolutions.hygienehabitsapp.Data.Model.Entities

import com.google.gson.annotations.SerializedName

data class InfoTutorModel(
    @SerializedName("idTutor")
    val idTutor:Int,
    @SerializedName("authTokenTutor")
    val authTokenTutor:String
)
