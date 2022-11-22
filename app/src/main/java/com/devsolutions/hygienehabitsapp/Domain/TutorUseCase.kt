package com.devsolutions.hygienehabitsapp.Domain

import com.devsolutions.hygienehabitsapp.Data.Model.Entities.TutorModel
import com.devsolutions.hygienehabitsapp.Data.Repository.TutorRepository

class TutorUseCase {
    private val repository = TutorRepository()
    suspend fun getAllTutor():List<TutorModel>{
        return repository.getAllTutors()
    }

    suspend fun authUser(user: String, password: String): Boolean {
        return repository.authUser(user, password);
    }

    suspend fun crearCuenta(username: String, age: String, password: String): Int {
        return repository.crearCuenta(username, age, password)
    }

    suspend fun getTutorById(tutorId: Int): TutorModel {
        //return repository.getTutorById(tutorId)
        return TutorModel("1", "Tutor","123", "34", "123abc")
    }


}