package com.deto.calculadorametabolismobasal2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                .background(BackGround)
        ) {

            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = estatura,
                        onValueChange = { estatura = it },
                        placeholder = { Text("1.75") },
                        label = { Text("Estatura (m)") }
                    )

                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = estatura,
                        onValueChange = { estatura = it },
                        placeholder = { Text("75") },
                        label = { Text("Peso (kgs)") }
                    )

                }

            }
        }

    }

}