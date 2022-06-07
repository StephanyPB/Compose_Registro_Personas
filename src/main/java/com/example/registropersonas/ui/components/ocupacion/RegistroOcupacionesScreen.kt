package com.example.registropersonas.ui.components.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Work
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegistroOcupacionesScreen( navHostController: NavHostController, ocupacionViewModel: OcupacionViewModel = hiltViewModel() ) {

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro Ocupaciones") })
    },
            scaffoldState = ScaffoldState
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Default.Work, contentDescription = null) },
                value = ocupacionViewModel.nombre,
                onValueChange = { ocupacionViewModel.nombre = it },
                label = { Text(text = "Ocupacion:") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    ocupacionViewModel.guardar()
                    navHostController.navigate("ConsultaOcupaciones") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)) {
                Text(text = "Guardar")
            }
        }
    }
}