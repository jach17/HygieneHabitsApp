package com.devsolutions.hygienehabitsapp.Data.Repository

import com.devsolutions.hygienehabitsapp.Data.Model.Dto.AuthUserDto
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.TutorModel
import com.devsolutions.hygienehabitsapp.Data.Service.TutorService
import org.json.JSONObject

class TutorRepository {
    private val api = TutorService()

    suspend fun getAllTutors():List<TutorModel>{
        val res = api.getAllTutors()
        var tutorsList = arrayListOf<TutorModel>()
        if(res.body()?.result=="1"){
            tutorsList = res.body()?.message?.response!! as ArrayList<TutorModel>
        }
        println(tutorsList)
        return tutorsList
    }

    suspend fun authUser(user: String, password: String): Boolean {

        val body = AuthUserDto(user, password)
        val res = api.authUser(body)
        val isRegistred = res.body()?.message?.response?.get(0)

        return isRegistred?.isRegistred!!

    }
}
