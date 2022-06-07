package com.example.registropersonas.ui.components.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ConsutaOcupacionesScreen(navHostController: NavHostController, viewModel: OcupacionViewModel = hiltViewModel()){

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar ={
            TopAppBar(title = { Text(text = "Lista de Ocupaciones")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate("RegistroOcupaciones")
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Create, contentDescription = "Crear")
            }
        },
        scaffoldState = ScaffoldState
    ){
            Column(modifier = Modifier.padding(8.dp)) {

                val ListOcupacion = viewModel.ocupacion.collectAsState(initial = emptyList())

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(ListOcupacion.value) { ocupacion ->
                        Row() {
                            Text("${ocupacion.ocupacionId}\t\t\t"
                            +"${ocupacion.nombres}")
                        }
                    }
                }
            }
    }
}