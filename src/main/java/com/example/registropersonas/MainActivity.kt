package com.example.registropersonas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registropersonas.ui.components.ocupacion.*
import com.example.registropersonas.ui.components.ocupacion.ConsutaOcupacionesScreen
import com.example.registropersonas.ui.components.persona.*
import com.example.registropersonas.util.Screen.ConsultaOcupacionesScreen
import com.example.registropersonas.ui.theme.RegistroPersonasTheme
import com.example.registropersonas.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
    RegistroPersonasTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController()

            NavHost(navController = navHostController, startDestination = "ConsultaPersonas") {
                composable("ConsultaPersonas") {
                    ConsutaPersonasScreen(navHostController = navHostController)
                }
                composable("RegistroPersonas") {
                    RegistroPersonaScreen(navHostController = navHostController)
                }

                composable("ConsultaOcupaciones") {
                    ConsutaOcupacionesScreen(navHostController = navHostController)
                }
                composable("RegistroOcupaciones") {
                    RegistroOcupacionesScreen(navHostController = navHostController)
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