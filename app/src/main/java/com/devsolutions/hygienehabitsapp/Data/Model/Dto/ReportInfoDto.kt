package com.devsolutions.hygienehabitsapp.Data.Model.Dto

data class ReportInfoDto(
    val namePlayer:String,
    val nameLevelPlayed:String,
    val sessionDate:String,
    val playingTime:String,
    val currentScore:String,
    val maxScorePosible:String,
    val progress:Float
)
