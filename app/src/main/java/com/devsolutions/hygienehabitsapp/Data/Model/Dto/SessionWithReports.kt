package com.devsolutions.hygienehabitsapp.Data.Model.Dto

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.FullReportFromSessionModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.google.gson.annotations.SerializedName

data class SessionWithReports(
    val idSesion: Int,
    val dateStart: String,
    val dateEnd: String,
    val idPlayerOwner: Int,
    val reportsOfSession:ArrayList<FullReportFromSessionModel>
)