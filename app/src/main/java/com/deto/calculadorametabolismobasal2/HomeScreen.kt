package com.deto.calculadorametabolismobasal2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.deto.calculadorametabolismobasal2.ui.theme.BackGround
import com.deto.calculadorametabolismobasal2.ui.theme.Labels

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( navController: NavController ){

    var estatura by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    val sexs = listOf("Hombre", "Mujer")
    var expanded1 by remember { mutableStateOf(false) }
    var seleccionSexs by remember { mutableStateOf(sexs[0]) }

    val activity = listOf("Baja (rara vez o nunca)", "Ligera (1-3 veces por semana)","Moderada (3-5 veces por semana)","Alta (6 veces por semana)","Muy alta (Deportista Profesional)")
    var expanded2 by remember { mutableStateOf(false) }
    var seleccionActivity by remember { mutableStateOf(activity[1]) }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = stringResource(R.string.title),
                            textAlign = TextAlign.Center
                        )

                    }

                },
                colors = TopAppBarColors(
                    containerColor = BackGround,
                    titleContentColor = Labels,
                    actionIconContentColor = Labels,
                    scrolledContainerColor = Labels,
                    navigationIconContentColor = Labels
                )
            )
        }



    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(BackGround),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .padding(top = 16.dp)
                ) {

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = estatura,
                        onValueChange = { estatura = it },
                        placeholder = { Text("1.75") },
                        label = { Text("Estatura (m)") }
                    )

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                        value = edad,
                        onValueChange = { edad = it },
                        placeholder = { Text("21") },
                        label = { Text("Edad") }
                    )

                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .padding(top = 16.dp)
                ) {

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = peso,
                        onValueChange = { peso = it },
                        placeholder = { Text("75") },
                        label = { Text("Peso (kgs)") }
                    )



                    ExposedDropdownMenuBox(
                        expanded = expanded1,
                        onExpandedChange = { expanded1 = !expanded1 },
                        modifier = Modifier.padding(top = 24.dp)
                    ) {
                        TextField(
                            value = seleccionSexs,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Sexo") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded1) },
                            modifier = Modifier
                                .menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true)
                                .fillMaxWidth()
                        )

                        ExposedDropdownMenu(
                            expanded = expanded1,
                            onDismissRequest = { expanded1 = false }
                        ) {
                            sexs.forEach { opcion ->
                                DropdownMenuItem(
                                    text = { Text(opcion) },
                                    onClick = {
                                        seleccionSexs = opcion
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
                modifier = Modifier.padding(16.dp)
            ) {
                TextField(
                    value = seleccionActivity,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Sexo") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded2) },
                    modifier = Modifier
                        .menuAnchor(type = MenuAnchorType.PrimaryEditable, enabled = true)
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(
                    expanded = expanded2,
                    onDismissRequest = { expanded2 = false }
                ) {
                    activity.forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(opcion) },
                            onClick = {
                                seleccionActivity = opcion
                                expanded2 = false
                            }
                        )
                    }
                }

            }

        }

    }

}