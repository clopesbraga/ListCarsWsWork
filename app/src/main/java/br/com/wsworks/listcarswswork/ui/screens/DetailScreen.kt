package br.com.wsworks.listcarswswork.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.wsworks.listcarswswork.model.api.Car
import br.com.wsworks.listcarswswork.viewmodel.ListCarViewModel
import com.google.gson.Gson
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(navController: NavHostController, car: String?) {
    val viewModel = koinViewModel<ListCarViewModel>()
    val car = car?.let { Gson().fromJson(it, Car::class.java) }
    Column(
        modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
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
                    onClick = {
                      car?.let{ viewModel.save(it)}
                    },
                ) {
                    Text("Eu quero")
                }

            }
        }
    }
}