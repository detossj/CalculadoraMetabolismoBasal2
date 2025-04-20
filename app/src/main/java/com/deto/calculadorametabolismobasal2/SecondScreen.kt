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
            .background(BackGround),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Card(
                modifier = Modifier.fillMaxWidth().padding(top = 30.dp).padding(horizontal = 12.dp)

            ) {

                Column(
                    modifier = Modifier.padding(32.dp)
                ) {
                    Text(
                        text = "Tu Metabolismo Basal es de",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    Text(
                        text = "${resultado} Kcal/dia",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 40.dp)
                    )


                    Text(
                        text = "Calorias diarias a consumir para bajar:",
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Text("1 kg al mes = ${CalcularDeficitCalorico(1,resultado)} Kcal/dia")
                    Text("2 kg al mes = ${CalcularDeficitCalorico(2,resultado)} Kcal/dia")
                    Text("3 kg al mes = ${CalcularDeficitCalorico(3,resultado)} Kcal/dia")
                    Text("4 kg al mes = ${CalcularDeficitCalorico(4,resultado)} Kcal/dia")


                    Text(
                        text = "Calorias diarias a consumir para subir:",
                        modifier = Modifier.padding(top = 40.dp,bottom = 20.dp)
                    )

                    Text("1 kg al mes = ${CalcularSuperavitCalorico(1,resultado)} Kcal/dia")
                    Text("2 kg al mes = ${CalcularSuperavitCalorico(2,resultado)} Kcal/dia")
                    Text("3 kg al mes = ${CalcularSuperavitCalorico(3,resultado)} Kcal/dia")
                    Text("4 kg al mes = ${CalcularSuperavitCalorico(4,resultado)} Kcal/dia")

                    Text(
                        text = "Recuerda siempre consultar a un especialista en nutrición para bajar de peso de forma saludable.",
                        modifier = Modifier.padding(top = 40.dp,bottom = 20.dp)
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