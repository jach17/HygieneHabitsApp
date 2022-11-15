package com.devsolutions.hygienehabitsapp.Data.Model.Responses.MessageSuccess

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.SessionModel
import com.google.gson.annotations.SerializedName

data class MesssageSuccessListSessionsResponse(
    @SerializedName("response")
    val response:ArrayList<SessionModel>
)
