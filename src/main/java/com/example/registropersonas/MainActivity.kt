package com.example.registropersonas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registropersonas.ui.theme.RegistroPersonasTheme
import com.example.registropersonas.util.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    MyApps()
                }
            }
        }
@Composable
fun MyApps() {
    RegistroPersonasTheme{
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
        val navHostController = rememberNavController()

        NavHost(navController = navHostController, startDestination = com.example.registropersonas.util.Screen.ConsutaPersonasScreen.route){

            composable(route = com.example.registropersonas.util.Screen.ConsutaPersonasScreen.route){
                ConsutaPersonasScreen(goRegistPerson = {
                    navHostController.navigate(com.example.registropersonas.util.Screen.RegistroPersonaScreen.route) },
                goOcupList = {navHostController.navigate(com.example.registropersonas.util.Screen.ConsultaOcupacionesScreen.route)})
            }

            composable(route = com.example.registropersonas.util.Screen.RegistroPersonaScreen.route){
                RegistroPersonaScreen(goListPerson ={ navHostController.navigate(com.example.registropersonas.util.Screen.ConsutaPersonasScreen.route)})
            }

            composable(route = com.example.registropersonas.util.Screen.ConsultaOcupacionesScreen.route){
                ConsultaOcupacionesScreen(GoOcupRegist = {navHostController.navigate(com.example.registropersonas.util.Screen.RegistroOcupacionesScreen.route)})
            }

            composable(route = com.example.registropersonas.util.Screen.RegistroOcupacionesScreen.route){
                RegistroOcupacionesScreen(GoListOcup = {navHostController.navigate(com.example.registropersonas.util.Screen.ConsultaOcupacionesScreen.route)},
                    goListPerson = {navHostController.navigate(com.example.registropersonas.util.Screen.ConsutaPersonasScreen.route)})
            }
          }
        }
    }
}
@Composable
fun ConsutaPersonasScreen(goRegistPerson:() -> Unit,  goOcupList:()-> Unit){

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar ={
            TopAppBar(title = { Text(text = "Lista Personas")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goOcupList()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Ocupacion")
            }
        },
        scaffoldState = ScaffoldState

    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Button(onClick = {
                goRegistPerson()
            }) {
                Text("Nuevo")
            }

            val lista = listOf("Id: 1", "Nombre: Stephany", "Email: stephany@gmail.com", "Salario: 50,000")

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(lista) { nombre ->
                    Row() {
                        Text("$nombre")
                    }
                }
            }
        }
    }
}

@Composable
fun RegistroPersonaScreen(goListPerson:() -> Unit){

    var nombre by rememberSaveable() {
        mutableStateOf("")
    }

    var email by rememberSaveable() {
        mutableStateOf("")
    }

    var balance by rememberSaveable() {
        mutableStateOf("")
    }

    val ScaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Registro de Personas")}) })
    {
        Column(modifier = Modifier.padding(8.dp)) {

            OutlinedTextField(
                label = { Text( "Nombre:") },
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
                value =nombre ,
                onValueChange = {nombre = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = { Text( "Email:") },
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
                value =email ,
                onValueChange = {email = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = { Text( "Balance:") },
                leadingIcon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null) },
                value =balance ,
                onValueChange = {balance = it},
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedButton(onClick = {
                goListPerson()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text("Guardar ")
            }
        }
    }
}

@Composable
fun RegistroOcupacionesScreen(GoListOcup:() ->Unit,goListPerson:() -> Unit ) {

    var ocup by rememberSaveable() {
        mutableStateOf("")
    }

    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Lista Personas") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goListPerson()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        scaffoldState = ScaffoldState

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            OutlinedTextField(
                leadingIcon = { Icon(imageVector = Icons.Default.Done, contentDescription = null) },
                value = ocup,
                onValueChange = { ocup = it },
                label = { Text(text = "Ocupacion:") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    GoListOcup()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text(text = "Guardar")
            }
        }
    }
}


@Composable
fun ConsultaOcupacionesScreen(GoOcupRegist: () -> Unit){
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar ={
            TopAppBar(title = { Text(text = "Lista de Ocupaciones")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    GoOcupRegist()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Create, contentDescription = "Crear")
            }
        },
        scaffoldState = ScaffoldState

    ) {

        Column(modifier = Modifier.padding(8.dp)) {

        val ocupList = listOf("Id: 1", "Ocupacion: Usuario")

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(ocupList) { ocupacion ->
                Row() {
                    Text("$ocupacion")
                }
            }
          }
       }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RegistroPersonasTheme {
        MyApps()
    }
}