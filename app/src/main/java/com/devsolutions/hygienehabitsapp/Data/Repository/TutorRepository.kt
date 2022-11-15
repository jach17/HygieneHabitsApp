package com.devsolutions.hygienehabitsapp.Data.Repository

import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AddUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AuthUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.TutorModel
import com.devsolutions.hygienehabitsapp.Data.Service.TutorService

class TutorRepository {
    private val api = TutorService()

    suspend fun getAllTutors():List<TutorModel>{
        val res = api.getAllTutors()
        var tutorsList = arrayListOf<TutorModel>()
        if(res.body()?.result==Component.RESULT_OK){
            tutorsList = res.body()?.message?.response!! as ArrayList<TutorModel>
        }
        return tutorsList
    }

    suspend fun authUser(user: String, password: String): Boolean {
        val res = api.authUser(AuthUserDto(user, password))
        val result = res.body()?.result
        var isRegister=false
        if(result==Component.RESULT_OK){
            isRegister = res.body()?.message?.response?.get(0)!!.isRegistred
        }
        return isRegister
    }

    suspend fun crearCuenta(username: String, age: String, password: String): Int {
        //AutomatizeTokenGeneration
        val res = api.addUser(AddUserDto(username, password, age, "123abc"))
        val result = res.body()?.result
        var insertedId=0
        if(result==Component.RESULT_OK) {
            insertedId = res.body()?.message?.response?.get(0)!!.insertedId
        }
        return insertedId
    }

    suspend fun getTutorById(tutorId: Int): TutorModel {
        val res = api.getTutorById(tutorId)
        var tutorsList = arrayListOf<TutorModel>()
        if(res.body()?.result==Component.RESULT_OK){
            tutorsList = res.body()?.message?.response!!
        }
        return tutorsList[0]
    }


}
