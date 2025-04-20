package com.deto.calculadorametabolismobasal2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class SecondScreen(val resultado: Int)

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost( navController = navController, startDestination = Home){
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<SecondScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<SecondScreen>()
            SecondScreen(navController = navController, resultado = args.resultado)
        }
    }
}