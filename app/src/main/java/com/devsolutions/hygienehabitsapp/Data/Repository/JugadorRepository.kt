package com.devsolutions.hygienehabitsapp.Data.Repository

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddFeedbackDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.FullReportDto
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.FullReportModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.SessionModel
import com.devsolutions.hygienehabitsapp.Data.Service.JugadorService
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class JugadorRepository {
    private val api = JugadorService()

    suspend fun addTutorFeedbackOnReport(reportId: Int, feedback: String): Int {
        var feedbackInserted = 0
        try {
            val feedbackDto = AddFeedbackDto(feedback)
            val res = api.addTutorFeedback(reportId, feedbackDto)
            val result = res.body()?.result
            if (result == Component.RESULT_OK) {
                feedbackInserted = res.body()?.message?.response?.get(0)?.insertedId!!
            }
        } catch (e: Exception) {
            feedbackInserted = 0
        }
        return feedbackInserted
    }


    suspend fun getReportsFromPlayerId(id: Int): ArrayList<FullReportDto> {
        val listReportDto = arrayListOf<FullReportDto>()

        try {
            val res = api.getFullReportsFromPlayerId(id)
            val result = res.body()?.result
            var list = arrayListOf<FullReportModel>()
            if (result == Component.RESULT_OK) {
                list = res.body()?.message?.response!!
            }
            for (report in list) {
                val playingTime = getPlayingTime(report.dateStartLevel, report.dateEndLevel)

                val progress = getProgress(report.currentScoreLevel, report.maxScore)
                listReportDto.add(
                    FullReportDto(
                        report.idPlayer,
                        report.idReport,
                        report.descriptionTitle,
                        report.namePlayer,
                        playingTime,
                        report.currentScoreLevel,
                        report.maxScore,
                        progress,
                        report.dateStart,
                        report.tutorFeedback
                    )
                )
            }
        } catch (e: Exception) {
            println("Error on repository line 63: ${e.message}")
        }
        return listReportDto
    }

    private fun getProgress(currentScoreLevel: String, maxScorePossible: String): Float {
        return (currentScoreLevel.toFloat() * 100f) / maxScorePossible.toFloat()
    }


    @SuppressLint("SimpleDateFormat")
    private fun getPlayingTime(dateStartLevel: String, dateEndLevel: String): String {
        //FROMAT DATE dd-mm-aaaa hh-mm-ss a
        return "Calculate playing time"
    }


    suspend fun getSessionsFromPlayerId(id: Int): ArrayList<SessionModel> {
        val res = api.getSessionsFromPlayerId(id)
        val result = res.body()?.result
        var list = arrayListOf<SessionModel>()
        if (result == Component.RESULT_OK) {
            list = res.body()?.message?.response!!
        }
        return list


        /*
        val arrayList = arrayListOf<SessionModel>()
        arrayList.add(SessionModel(1,"dateStart", "dateEnd", 1))

        return arrayList
        */

    }


    suspend fun getPlayersFromTutorId(id: Int): ArrayList<JugadorModel> {

        val res = api.getPlayersByTutorId(id)
        val result = res.body()?.result
        var list = arrayListOf<JugadorModel>()
        if (result == Component.RESULT_OK) {
            list = res.body()?.message?.response!!
        }
        return list

        /*For local working
        val arrayList = arrayListOf<JugadorModel>()
        arrayList.add(JugadorModel(1,"Test1","Test1", "Test1", 1,"Test1", 1,2,3,4,5 ))
        return arrayList

         */
    }

    suspend fun getPlayerById(id: Int): JugadorModel? {
        val res = api.getPlayersById(id)
        val result = res.body()?.result
        var player: JugadorModel? = null
        if (result == Component.RESULT_OK) {
            player = res.body()?.message?.response!![0]
        }

        return player


        // return JugadorModel(1,"Test1","Test1", "Test1", 1,"Test1", 1,2,3,4,5 )
    }

/*
    suspend fun getFullReportsFromSessionId(sessionId: Int): ArrayList<ReportInfoDto> {
        /*Call to service */

        /*For local working*/

/*
        private fun calculateProgr(reporteModel: ReporteModel): Float {
            val total = 5f // MAXIMA PUNTUACION
            val current = reporteModel.currentScoreLevel.toFloat() //CURRENT SCORE
            return (current * 100f) / total
        }
        */
        val listOfReportsResponse = arrayListOf<ReporteModel>()
        listOfReportsResponse.add(
            ReporteModel(
                "1",
                "JonathanPlayer",
                "11-05-2022 15:20:22",
                "11-05-2022 15:25:22",
                "3",
                "Nivel 1",
                "15"
            )
        )

        val listOfFullReports = arrayListOf<ReportInfoDto>()

        for (report in listOfReportsResponse) {
            val sessionDate = report.dateStartLevel.split(" ")
            //For getting playing time get difference between dateStart and dateEnd
            val playingTime = "3 horas"
            val progressLevel =
                (report.currentScoreLevel.toFloat() * 100f) / report.maxScorePossible.toFloat()
            val reportDto = ReportInfoDto(
                report.namePlayer,
                report.descriptionTitle,
                sessionDate[0],
                playingTime,
                report.currentScoreLevel,
                report.maxScorePossible,
                progressLevel
            )
            listOfFullReports.add(reportDto)
        }

        return listOfFullReports

    }

 */
}