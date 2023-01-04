package com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.FullReportModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.google.gson.annotations.SerializedName

data class MessageSuccessListFullReportsResponse(
    @SerializedName("response")
    val response:ArrayList<FullReportModel>
)
