package com.example.registropersonas.ui.components.persona

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegistroPersonaScreen(navHostController: NavHostController, viewModel: PersonasViewModel = hiltViewModel()){


    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Registro de Personas") }) }
    ) {
            Column(modifier = Modifier.padding(8.dp)) {

                OutlinedTextField(
                    label = { Text("Nombre de la persona:") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null) },
                    value = viewModel.nombre,
                    onValueChange = { viewModel.nombre = it },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    label = { Text("Email:") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null) },
                    value = viewModel.email,
                    onValueChange = { viewModel.email = it },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    label = { Text("Salary:") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Money,
                            contentDescription = null) },
                    value = viewModel.balance,
                    onValueChange = { viewModel.balance = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {
                        viewModel.Guardar()
                        navHostController.navigateUp() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)) {
                    Text("Guardar ")
                }
            }
    }
}