package com.devsolutions.hygienehabitsapp.Data.Model.Entities

import com.google.gson.annotations.SerializedName

data class JugadorModel (
      @SerializedName("idPlayer") val idPlayer:Int,
      @SerializedName("namePlayer") val namePlayer:String,
      @SerializedName("passwordPlayer") val passwordPlayer:String,
      @SerializedName("agePlayer") val agePlayer: String,
      @SerializedName("idTutorOwner") val idTutorOwner:Int,
      @SerializedName("authTokenTutor") val authTokenTutor:String,
      @SerializedName("statusLevel1") val statusLevel1:Int,
      @SerializedName("statusLevel2") val statusLevel2:Int,
      @SerializedName("statusLevel3") val statusLevel3:Int,
      @SerializedName("statusLevel4") val statusLevel4:Int,
      @SerializedName("statusLevel5") val statusLevel5:Int
    )