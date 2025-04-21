package com.deto.calculadorametabolismobasal2

import android.R.string
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.deto.calculadorametabolismobasal2.ui.theme.BackGround
import com.deto.calculadorametabolismobasal2.ui.theme.Button
import com.deto.calculadorametabolismobasal2.ui.theme.Error
import com.deto.calculadorametabolismobasal2.ui.theme.Inputs
import com.deto.calculadorametabolismobasal2.ui.theme.Labels
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navController: NavController ){

    var altura by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    var error1 by remember { mutableStateOf(false) }
    var error2 by remember { mutableStateOf(false) }
    var error3 by remember { mutableStateOf(false) }

    val sexos = listOf("Hombre", "Mujer")
    var expanded1 by remember { mutableStateOf(false) }
    var seleccionSexos by remember { mutableStateOf(sexos[0]) }

    val actividad = listOf("Baja (rara vez o nunca)", "Ligera (1-3 veces por semana)","Moderada (3-5 veces por semana)","Alta (6 veces por semana)","Muy alta (Deportista Profesional)")
    var expanded2 by remember { mutableStateOf(false) }
    var seleccionActivitad by remember { mutableStateOf(actividad[1]) }


    Column(
        modifier = Modifier.fillMaxSize(),

    ) {

        Column(
            modifier = Modifier

                .fillMaxSize()
                .background(BackGround),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopAppBar(stringResource(R.string.home_title),stringResource(R.string.home_subtitle))

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .padding(top = 16.dp)
                ) {

                    CustomOutlinedTextField(altura, { altura = it }, stringResource(R.string.label_altura), stringResource(R.string.placeholder_altura), error1, stringResource(R.string.supportingText_altura))

                    CustomOutlinedTextField(edad, { edad = it },stringResource(R.string.label_edad), stringResource(R.string.placeholder_edad), error2, stringResource(R.string.supportingText_edad))


                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .padding(top = 16.dp)
                ) {

                    CustomOutlinedTextField(peso, { peso = it },stringResource(R.string.label_peso),stringResource(R.string.placeholder_peso), error3, stringResource(R.string.supportingText_peso))

                    ExposedDropdownMenuBox(
                        expanded = expanded1,
                        onExpandedChange = { expanded1 = !expanded1 },
                    ) {
                        OutlinedTextField(
                            value = seleccionSexos,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text(stringResource(R.string.label_sexo)) },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded1) },
                            modifier = Modifier
                                .menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true)
                                .fillMaxWidth()
                                .padding(top = 40.dp),
                            colors = ExposedDropdownMenuDefaults.textFieldColors(
                                focusedTextColor = Labels,
                                unfocusedTextColor = Labels,
                                focusedContainerColor = BackGround,
                                unfocusedContainerColor = BackGround,
                                focusedIndicatorColor = Labels,    // borde cuando enfocado
                                unfocusedIndicatorColor = Labels,  // borde cuando no está enfocado
                                disabledIndicatorColor = Labels,   // borde cuando está deshabilitado
                                focusedLabelColor = Labels,
                                unfocusedLabelColor = Labels
                            )
                        )

                        ExposedDropdownMenu(
                            expanded = expanded1,
                            onDismissRequest = { expanded1 = false }
                        ) {
                            sexos.forEach { opcion ->
                                DropdownMenuItem(
                                    text = { Text(opcion) },
                                    onClick = {
                                        seleccionSexos = opcion
                                        expanded1 = false
                                    }
                                )
                            }
                        }
                    }






                }



            }

            ExposedDropdownMenuBox(
                expanded = expanded2,
                onExpandedChange = { expanded2 = !expanded2 },
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)

            ) {
                OutlinedTextField(
                    value = seleccionActivitad,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(R.string.label_actividad)) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded2) },
                    modifier = Modifier
                        .menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true)
                        .fillMaxWidth(),
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        focusedTextColor = Labels,
                        unfocusedTextColor = Labels,
                        focusedContainerColor = BackGround,
                        unfocusedContainerColor = BackGround,
                        focusedIndicatorColor = Labels,    // borde cuando enfocado
                        unfocusedIndicatorColor = Labels,  // borde cuando no está enfocado
                        disabledIndicatorColor = Labels,   // borde cuando está deshabilitado
                        focusedLabelColor = Labels,
                        unfocusedLabelColor = Labels

                    )
                )

                ExposedDropdownMenu(
                    expanded = expanded2,
                    onDismissRequest = { expanded2 = false },
                ) {
                    actividad.forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(opcion) },
                            onClick = {
                                seleccionActivitad = opcion
                                expanded2 = false
                            },
                        )
                    }
                }

            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {

                TextButton(
                    onClick = {
                        error1 = altura.isEmpty()
                        error2 = edad.isEmpty()
                        error3 = peso.isEmpty()

                        if( !error1 && !error2 && !error3 ){
                            navController.navigate(SecondScreen(CaloriasTotales(seleccionActivitad,peso.toDouble(),altura.toDouble(),edad.toInt(),seleccionSexos)))
                        }
                    },
                    modifier = Modifier.fillMaxWidth().padding(top = 56.dp),
                    colors = ButtonColors(
                        contentColor = BackGround,
                        containerColor = Button,
                        disabledContentColor = BackGround,
                        disabledContainerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(10.dp)
                ){
                    Text(stringResource(R.string.button_text))
                }
            }

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar( title: String, subtitle: String ){
    LargeTopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        colors = TopAppBarColors(
            containerColor = BackGround,
            titleContentColor = Labels,
            actionIconContentColor = Button,
            scrolledContainerColor = BackGround,
            navigationIconContentColor = Button
        ),
        title = {
            Column {
                Text(
                    text = title,
                    color = Button,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                Text(
                    text = subtitle,
                    fontSize = 14.sp
                )
            }
        }
    )
}

@Composable
fun CustomOutlinedTextField( value: String, onValueChange: (String) -> Unit, label: String, placeholder: String, error: Boolean, supportingText: String ){

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        label = { Text(label) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Inputs,
            unfocusedTextColor = Inputs,
            focusedContainerColor = BackGround,
            unfocusedContainerColor = BackGround,
            focusedBorderColor = Labels,
            unfocusedBorderColor = Labels,
            focusedLabelColor = Labels,
            unfocusedLabelColor = Labels,
            errorTextColor = Error,
            errorSupportingTextColor = Error,
            errorLabelColor = Error,
            errorBorderColor = Error,
            errorContainerColor = BackGround
        ),
        minLines = 1,
        maxLines = 1,
        isError = error,
        supportingText = { if(error) Text(supportingText) else {} }


    )
}

fun TasaMetabolismoBasal( peso: Double, altura: Double, edad: Int, sexo: String ): Double {

    var resultado = 0.0
    if(sexo == "Hombre"){
        resultado = (10 * peso) + (6.25 * altura) - (5 *edad) + 5
    } else if(sexo == "Mujer"){
        resultado = (10 * peso) + (6.25 * altura) - (5 *edad) - 161
    }

    return resultado
}

fun CaloriasTotales( actividad: String, peso: Double, altura: Double, edad: Int, sexo: String ): Int {

    var resultado = 0.0

    when{
        actividad == "Baja (rara vez o nunca)" -> resultado = TasaMetabolismoBasal(peso,altura,edad,sexo) * 1.2
        actividad == "Ligera (1-3 veces por semana)" -> resultado = TasaMetabolismoBasal(peso,altura,edad,sexo) * 1.375
        actividad == "Moderada (3-5 veces por semana)" -> resultado = TasaMetabolismoBasal(peso,altura,edad,sexo) * 1.55
        actividad == "Alta (6 veces por semana)" -> resultado = TasaMetabolismoBasal(peso,altura,edad,sexo) * 1.725
        actividad == "Muy alta (Deportista Profesional)" -> resultado = TasaMetabolismoBasal(peso,altura,edad,sexo) * 1.9
    }

    return resultado.roundToInt()
}