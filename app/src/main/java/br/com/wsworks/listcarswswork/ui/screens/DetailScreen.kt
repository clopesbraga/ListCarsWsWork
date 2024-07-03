package br.com.wsworks.listcarswswork.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.wsworks.listcarswswork.model.api.Car
import br.com.wsworks.listcarswswork.viewmodel.ListCarViewModel
import com.google.gson.Gson
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, car: String?) {
    val viewModel = koinViewModel<ListCarViewModel>()
    val car = car?.let { Gson().fromJson(it, Car::class.java) }

    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("Detalhes do Carro") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("list")
                    }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.Yellow)
            )
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = shape,
                colors = CardDefaults.cardColors(Color.Yellow),
                border = BorderStroke(10.dp, Color.Black)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Modelo: ${car?.nome_modelo}")
                    Text("Ano:${car?.ano}")
                    Text("Combustivel: ${car?.combustivel}")
                    Text("Cor:${car?.cor}")
                    Text("Id: ${car?.id}")
                    Text("Modelo ID:${car?.modelo_id}")
                    Text("Valor:${car?.valor}")
                    Text("Timestamp:${car?.timestamp_cadastro}")
                    Text("Num Portas:${car?.num_portas}")

                    Button(
                        modifier = Modifier
                            .size(100.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        onClick = { car?.let { viewModel.save(it) } },
                    ) {
                        Text(
                            "Eu quero",
                            textAlign= TextAlign.Center,
                            fontSize = 15.sp
                        )
                    }

                }
            }
        }

    }

}