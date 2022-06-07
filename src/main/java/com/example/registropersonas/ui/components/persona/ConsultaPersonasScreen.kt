package com.example.registropersonas.ui.components.persona

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ConsutaPersonasScreen( navHostController: NavHostController,
                          viewModel: PersonasViewModel = hiltViewModel()
){
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar ={
            TopAppBar(title = { Text( "Lista Personas") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate("RegistroOcupaciones")
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Ocupacion")
            }
        },
        scaffoldState = ScaffoldState
    ){
            Column(modifier = Modifier.padding(8.dp)) {
                Button(onClick = {
                    navHostController.navigate("RegistroPersonas") }) {
                    Text("New Person") }

                val listaPerson = viewModel.personas.collectAsState(initial = emptyList())

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(listaPerson.value) { persons ->
                        Row() {
                            Text( "${persons.personaId}\t\t\t " +
                                    "${persons.nombres}\t\t\t " +
                                    "${persons.email}\t\t\t " +
                                    "${persons.salario}")
                        }
                    }
                }
            }
    }
}
