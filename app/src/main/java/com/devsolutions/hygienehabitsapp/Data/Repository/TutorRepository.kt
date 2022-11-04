package com.devsolutions.hygienehabitsapp.Data.Repository

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.TutorModel
import com.devsolutions.hygienehabitsapp.Data.Service.TutorService

class TutorRepository {
    private val api = TutorService()

    suspend fun getAllTutors():List<TutorModel>{
       try{
           val res = api.getAllTutors()
           println("value of list: ${res.body()?.message?.response}")

       }catch(e:Exception){
           println("Error bro: $e")
       }

        val listaPAChecar = arrayListOf<TutorModel>()
        listaPAChecar.add(TutorModel("1", "Jony", "1323", "42", "123abc"))

        return listaPAChecar
    }
}
