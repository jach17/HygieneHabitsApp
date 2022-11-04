package com.devsolutions.hygienehabitsapp.Data.Model.Entities

import com.google.gson.annotations.SerializedName

data class TutorModel(
    @SerializedName("idTutor") val idTutor:String,
    @SerializedName("nameTutor") val nameTutor:String,
    @SerializedName("passwordTutor") val passwordTutor:String,
    @SerializedName("ageTutor") val ageTutor:String,
    @SerializedName("authTokenTutor") val authTokenTutor:String
)