package com.example.registropersonas.ui.components.persona

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registropersonas.data.repository.PersonaRepository
import com.example.registropersonas.model.Persona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonasViewModel @Inject constructor(
    val personaRepository: PersonaRepository
): ViewModel() {

    var personas = personaRepository.getList()

    var nombre by mutableStateOf("")

    var email by mutableStateOf("")

    var balance by  mutableStateOf("")

    fun Guardar(){
        viewModelScope.launch {
            personaRepository.insertar(
                Persona(
                    nombres = nombre,
                    email = email,
                    salario = balance.toString().toFloat()
                )
            )
        }
    }
}