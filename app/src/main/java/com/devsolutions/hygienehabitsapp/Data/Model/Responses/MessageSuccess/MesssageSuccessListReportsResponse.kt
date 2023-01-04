package com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.google.gson.annotations.SerializedName

data class MesssageSuccessListReportsResponse(
    @SerializedName("response")
    val response:ArrayList<ReporteModel>
)
