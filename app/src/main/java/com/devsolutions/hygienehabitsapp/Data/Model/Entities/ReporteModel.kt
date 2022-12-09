package com.devsolutions.hygienehabitsapp.Data.Model.Entities

import com.google.gson.annotations.SerializedName

data class ReporteModel(
    @SerializedName("idPlayer") val idPlayer: String,
    @SerializedName("idPlayer") val idReport: String,
    @SerializedName("namePlayer") val namePlayer: String ,
    @SerializedName("dateStartLevel") val dateStartLevel: String,
    @SerializedName("dateEndLevel") val dateEndLevel: String ,
    @SerializedName("currentScoreLevel") val currentScoreLevel: String ,
    @SerializedName("descriptionTitle") val descriptionTitle: String,
    @SerializedName("tutorFeedback") val tutorFeedback: String
)