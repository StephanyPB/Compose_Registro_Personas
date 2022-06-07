package com.example.registropersonas.ui.components.ocupacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registropersonas.data.OcupacionDao
import com.example.registropersonas.data.repository.OcupacionRepository
import com.example.registropersonas.model.Ocupacion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OcupacionViewModel @Inject constructor(
    val ocupacionRepository: OcupacionRepository
) : ViewModel(){

    var ocupacion = ocupacionRepository.getList()

    var nombre by mutableStateOf("")

    fun guardar(){
        viewModelScope.launch {
            ocupacionRepository.
            insertar(
                Ocupacion(
                    nombres = nombre )
            )
        }
    }

}