package br.com.wsworks.listcarswswork.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.wsworks.listcarswswork.R
import br.com.wsworks.listcarswswork.model.api.Car
import br.com.wsworks.listcarswswork.viewmodel.ListCarViewModel
import com.google.gson.Gson
import org.koin.androidx.compose.koinViewModel



@Preview(showBackground = true)
@Composable

fun ListPreview() {
    ListScreen(navController = rememberNavController())
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListScreen(navController: NavHostController) {

    val viewModel = koinViewModel<ListCarViewModel>()
    val listcars: List<Car> by viewModel.listCarsState.collectAsState()

    viewModel.getListCars()

    val items: List<Car> = listcars.map { cars ->
        Car(
           cars.id,
            cars.timestamp_cadastro,
            cars.modelo_id,
            cars.ano,
            cars.combustivel,
            cars.num_portas,
            cars.cor,
            cars.nome_modelo,
            cars.valor
        )
    }
    LazyColumn {

        stickyHeader{
            Box {
                Column(modifier = Modifier.background(Color.Yellow)) {

                    Text(
                        text = "Lista de carros",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 32.dp, top = 40.dp, bottom = 32.dp),
                    )
                }
            }
        }
        items(items) { car ->
            Column(modifier = Modifier.padding(48.dp)) {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val carJson = Gson().toJson(car)
                        navController.navigate("detail/$carJson")
                    },
                    shape = shape,
                    border = BorderStroke(5.dp, Color.Black),
                    colors = CardDefaults.cardColors(Color.Yellow)
                ) {
                    Row(){
                        Image(
                            painter = painterResource(id = R.mipmap.ic_ws_list_car_foreground),
                            contentDescription = null
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.Start
                        ) {

                            Text("Modelo: ${car.nome_modelo}")
                            Text("Ano:${car.ano}")
                            Text("Combustivel: ${car.combustivel}")
                            Text("Cor:${car.cor}")
                        }
                    }
                }
            }
        }
    }

}