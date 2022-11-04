package com.devsolutions.hygienehabitsapp.Data.Model.Responses

import com.google.gson.annotations.SerializedName

data class TutorResponse(
    @SerializedName("idTutor") val idTutor : Int,
    @SerializedName("nameTutor") val nameTutor : String,
    @SerializedName("passwordTutor") val passwordTutor : String,
    @SerializedName("ageTutor") val ageTutor : String,
    @SerializedName("authTokenTutor") val authTokenTutor : String
)