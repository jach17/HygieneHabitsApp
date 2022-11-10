package com.devsolutions.hygienehabitsapp.UI.App.Jugadores

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Domain.JugadorUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JugadoresViewModel:ViewModel() {

    private val jugadorUseCase = JugadorUseCase()

    fun getReportsFromPlayerId(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            jugadorUseCase.getReportsFromPlayerId(id)
        }
    }
}