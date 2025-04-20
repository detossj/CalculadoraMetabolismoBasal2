package com.deto.calculadorametabolismobasal2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.deto.calculadorametabolismobasal2.ui.theme.BackGround


@Composable
fun SecondScreen(navController: NavController, resultado: Int){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier.fillMaxWidth().padding(top = 30.dp).padding(horizontal = 12.dp)

            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Tu Metabolismo Basal es de",
                        fontSize = 16.sp
                    )
                    Text(
                        text = "${resultado} Kcal/dia",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


            }
        }
    }

}

fun CalcularDeficitCalorico( cantidadKilos: Int, resultado: Int): Int {

    val resultado = resultado - (7700 * cantidadKilos) / 30

    return resultado
}

fun CalcularSuperavitCalorico( cantidadKilos: Int, resultado: Int): Int {

    val resultado = resultado + (7700 * cantidadKilos) / 30

    return resultado
}