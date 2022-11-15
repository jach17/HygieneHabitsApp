package com.devsolutions.hygienehabitsapp.Data.Model.Entities

import com.google.gson.annotations.SerializedName

data class SessionModel(
    @SerializedName("idSesion") val idSesion: Int,
    @SerializedName("dateStart") val dateStart: String,
    @SerializedName("dateEnd") val dateEnd: String,
    @SerializedName("idPlayerOwner") val idPlayerOwner: Int
)
