package com.devsolutions.hygienehabitsapp.Data.Model.Dto

import com.google.gson.annotations.SerializedName

data class FullReportDto(
    val idPlayer: String,
    val descriptionTitle: String,
    val namePlayer: String,
    val playingTime:String,
    val currentScoreLevel: String,
    val maxScore: String,
    val progress:Float,
    val dateStart: String,
    val tutorFeedback: String
)