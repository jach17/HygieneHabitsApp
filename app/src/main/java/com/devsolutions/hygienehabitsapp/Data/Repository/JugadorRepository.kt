package com.devsolutions.hygienehabitsapp.Data.Repository

import android.os.Build
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddFeedbackDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.FullReportDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.SessionWithReports
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.FullReportFromSessionModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.FullReportModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.SessionModel
import com.devsolutions.hygienehabitsapp.Data.Service.JugadorService
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
                val playingTime = getPlayingTime(
                    getCorrectFormatForDate(report.dateStartLevel),
                    getCorrectFormatForDate(report.dateEndLevel)
                )

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
                        getCorrectFormatForDate(report.dateStart),
                        report.tutorFeedback
                    )
                )
            }
        } catch (e: Exception) {
            println("Error on repository line 67: ${e.message}")
        }
        return listReportDto
    }

    private fun getCorrectFormatForDate(date: String): String {
        val dateList = date.split(" ")

        var date =""
        date = if(dateList[0].length ==9 ){
            "0${dateList[0]}"
        }else{
            dateList[0]
        }
        var time = ""
        time = if (dateList[1].length == 7) {
            "0${dateList[1]}"
        } else {
            dateList[1]
        }
        return "$date $time"
    }


    private fun getProgress(currentScoreLevel: String, maxScorePossible: String): Float {
        return (currentScoreLevel.toFloat() * 100f) / maxScorePossible.toFloat()
    }

    private fun getPlayingTime(dateStartLevel: String, dateEndLevel: String): String {
        var out = ""
        try {
            out = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //FROMAT DATE dd-mm-aaaa hh-mm-ss a
                val format_date = "MM-dd-yyyy HH:mm:ss"
                val start_date_test = LocalDateTime.parse(
                    dateStartLevel.substring(0, 19),
                    DateTimeFormatter.ofPattern(format_date)
                )
                val end_date_test = LocalDateTime.parse(
                    dateEndLevel.substring(0, 19),
                    DateTimeFormatter.ofPattern(format_date)
                )
                "${Duration.between(start_date_test, end_date_test).seconds}"
            } else {
                "VERSION NOT COMPATIBLE"
            }
        } catch (e: Exception) {
            out = e.message!!
        }
        return out
    }

    suspend fun getSessionsFromPlayerId(id: Int): ArrayList<SessionWithReports> {
        val listSessions = arrayListOf<SessionWithReports>()
        try {
            val res = api.getSessionsFromPlayerId(id)
            val result = res.body()?.result
            var list = arrayListOf<SessionModel>()
            if (result == Component.RESULT_OK) {
                list = res.body()?.message?.response!!
            }

            list.forEach {
                val reportsBySession = getFullReportsFromSessionId(it.idSesion)
                listSessions.add(
                    SessionWithReports(
                        it.idSesion,
                        it.dateStart,
                        it.dateStart,
                        it.idPlayerOwner,
                        reportsBySession
                    )
                )
            }
        } catch (e: Exception) {
            println("Error on jugadorRepo, line 109")
            listSessions.clear()
        }
        return listSessions
    }

    suspend fun getPlayersFromTutorId(id: Int): ArrayList<JugadorModel> {
        var list = arrayListOf<JugadorModel>()
        try {
            val res = api.getPlayersByTutorId(id)
            val result = res.body()?.result
            if (result == Component.RESULT_OK) {
                list = res.body()?.message?.response!!
            } else {
                list.clear()
            }
        } catch (e: Exception) {
            println("Error on jugador repo line 152. E: ${e.message}")
            list.clear()
        }
        return list
    }

    suspend fun getPlayerById(id: Int): JugadorModel? {
        var player: JugadorModel? = null
        try {
            val res = api.getPlayersById(id)
            val result = res.body()?.result
            if (result == Component.RESULT_OK) {
                player = res.body()?.message?.response!![0]
            }
        } catch (e: Exception) {
            println("Error on jugador repo. Line 167 ${e.message}")
        }
        return player
    }


    suspend fun getFullReportsFromSessionId(sessionId: Int): ArrayList<FullReportFromSessionModel> {
        var list = arrayListOf<FullReportFromSessionModel>()
        try {
            val res = api.getFullReportsFromSessionId(sessionId)
            val result = res.body()?.result
            if (result == Component.RESULT_OK) {
                val listaCompleta = res.body()?.message?.response!!
                listaCompleta.forEach {
                    if(it.idReport!=0){
                        list.add(it)
                    }
                }
            } else {
                list.clear()
            }
        } catch (e:Exception) {
            println("Error on jugador repo. Line 184 ${e.message}")
            list.clear()
        }
        return list
    }
}