package com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.FullReportFromSessionModel
import com.google.gson.annotations.SerializedName

data class MessageSuccessListFullReportsFromSessionResponse(
    @SerializedName("response")
    val response:ArrayList<FullReportFromSessionModel>
)
