package com.devsolutions.hygienehabitsapp.Data.Repository

import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.SessionModel
import com.devsolutions.hygienehabitsapp.Data.Service.JugadorService

class JugadorRepository {
    private val api = JugadorService()

    suspend fun getReportsFromPlayerId(id: Int): ArrayList<ReporteModel> {
        /*
        val res = api.getReportsFromPlayerId(id)

        val result = res.body()?.result
        var list = arrayListOf<ReporteModel>()
        if(result== Component.RESULT_OK) {
            list = res.body()?.message?.response!!
        }
        return list

         */
        val arrayList = arrayListOf<ReporteModel>()
        arrayList.add(
            ReporteModel("1", "ASDF", "DATEsTART", "DateEnd", "3","tituloLevel")
        )

        return arrayList


    }


    suspend fun getSessionsFromPlayerId(id: Int): ArrayList<SessionModel> {
        /*val res = api.getSessionsFromPlayerId(id)
        val result = res.body()?.result
        var list = arrayListOf<SessionModel>()
        if(result== Component.RESULT_OK) {
            list = res.body()?.message?.response!!
        }
        return list

         */
        val arrayList = arrayListOf<SessionModel>()
        arrayList.add(SessionModel(1,"dateStart", "dateEnd", 1))

        return arrayList

    }


    suspend fun getPlayersFromTutorId(id:Int): ArrayList<JugadorModel> {
        /*
        val res = api.getPlayersByTutorId(id)
        val result = res.body()?.result
        var list = arrayListOf<JugadorModel>()
        if(result== Component.RESULT_OK) {
            list = res.body()?.message?.response!!
        }
        return list

         */
        /*For local working*/
        val arrayList = arrayListOf<JugadorModel>()
        arrayList.add(JugadorModel(1,"Test1","Test1", "Test1", 1,"Test1", 1,2,3,4,5 ))
        return arrayList
    }

    suspend fun getPlayerById(id: Int): JugadorModel? {
        /*val res = api.getPlayersById(id)
        val result = res.body()?.result
        var player:JugadorModel?=null
        if(result== Component.RESULT_OK) {
            player = res.body()?.message?.response!![0]
        }

        return player

         */
        return JugadorModel(1,"Test1","Test1", "Test1", 1,"Test1", 1,2,3,4,5 )
    }
}