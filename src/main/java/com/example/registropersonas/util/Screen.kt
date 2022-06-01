package com.example.registropersonas.util

sealed class Screen(val route: String) {
    object RegistroPersonaScreen: Screen("RegistroPersonas")
    object RegistroOcupacionesScreen: Screen("RegistroOcupaciones")

    object ConsutaPersonasScreen: Screen("ConsultaPersonas")
    object ConsultaOcupacionesScreen: Screen("ConsultaOcupaciones")

}