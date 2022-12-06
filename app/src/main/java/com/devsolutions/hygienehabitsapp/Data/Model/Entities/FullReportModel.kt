package com.devsolutions.hygienehabitsapp.Data.Model.Entities

import com.google.gson.annotations.SerializedName

data class FullReportModel(
    @SerializedName("idPlayer") val idPlayer: String,
    @SerializedName("descriptionTitle") val descriptionTitle: String,
    @SerializedName("namePlayer") val namePlayer: String,
    @SerializedName("dateStartLevel") val dateStartLevel: String,
    @SerializedName("dateEndLevel") val dateEndLevel: String,
    @SerializedName("currentScoreLevel") val currentScoreLevel: String,
    @SerializedName("maxScore") val maxScore: String,
    @SerializedName("dateStart") val dateStart: String,
    @SerializedName("tutorFeedback") val tutorFeedback: String
    )
