package br.com.wsworks.listcarswswork.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.wsworks.listcarswswork.model.Car
import br.com.wsworks.listcarswswork.model.ListCarsModel
import br.com.wsworks.listcarswswork.viewmodel.ListCarViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListScreen(navController: NavHostController) {

    val viewModel = koinViewModel<ListCarViewModel>()
    val listcars: List<Car> by viewModel.listCarsState.collectAsState()


    viewModel.getListCars()

    val items: List<Car> = listcars.map { cars ->
        Car(cars.ano,
            cars.combustivel,
            cars.cor,
            cars.id,
            cars.modelo_id,
            cars.nome_modelo,
            cars.num_portas,
            cars.timestamp_cadastro,
            cars.valor
        )
    }

    LazyColumn {
        items(items) { car ->
            CarItem(car)
        }
    }

}

@Composable
fun CarItem(car: Car) {
    Column(modifier = Modifier.padding(48.dp)) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Modelo: ${car.nome_modelo}")
                Text("Ano:${car.ano}")
                Text("Combustivel: ${car.combustivel}")
                Text("Cor:${car.cor}")
                Text("Id: ${car.id}")
                Text("Modelo ID:${ car.modelo_id}")
            }
        }
    }
}