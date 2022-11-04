package com.devsolutions.hygienehabitsapp.Data.Model.Entities

import com.google.gson.annotations.SerializedName

data class ErrorModel(
    @SerializedName("Error")
    val error:String
)