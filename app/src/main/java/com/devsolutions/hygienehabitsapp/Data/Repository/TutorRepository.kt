package com.devsolutions.hygienehabitsapp.Data.Repository

import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AuthUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.TutorModel
import com.devsolutions.hygienehabitsapp.Data.Service.TutorService
import java.util.*

class TutorRepository {
    private val api = TutorService()

    suspend fun authUser(user: String, password: String): Boolean {
        var isRegister = false
        try {
            val res = api.authUser(AuthUserDto(user, password))
            val result = res?.body()?.result
            if (result == Component.RESULT_OK) {
                isRegister = res.body()?.message?.response?.get(0)!!.isRegistred
            }
        } catch (e: Exception) {
            isRegister = false
            println("Error on tutor repo line 30")
        }
        return isRegister
    }

    suspend fun crearCuenta(username: String, age: String, password: String): Int {
        var insertedId = 0
        try {
            val token: String = getTokenTutor(username)
            val res = api.addUser(AddUserDto(username, password, age, token))
            val result = res.body()?.result
            if (result == Component.RESULT_OK) {
                insertedId = res.body()?.message?.response?.get(0)!!.insertedId
            }
        } catch (e: Exception) {
            println("Error on repo line 48. ${e.message}")
        }
        return insertedId
    }

    private fun getTokenTutor(name: String): String {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)
        val second = calendar.get(Calendar.SECOND)

        return "$name$day$month$year$hour$minute$second"
    }

    suspend fun getTutorById(tutorId: Int): TutorModel? {

        var tutorSelected:TutorModel?
        try{
        val res = api.getTutorById(tutorId)
        var tutorsList = arrayListOf<TutorModel>()
        if (res.body()?.result == Component.RESULT_OK) {
            tutorsList = res.body()?.message?.response!!
        }
            tutorSelected =tutorsList[0]
        }catch(e:Exception){
            tutorSelected=null
            println("Error on tutor repo. Line 74")
        }
        return tutorSelected
    }


}
