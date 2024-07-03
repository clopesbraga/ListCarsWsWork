package br.com.wsworks.listcarswswork.viewmodel


import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wsworks.listcarswswork.api.Endpoints
import br.com.wsworks.listcarswswork.api.WsWorksApi
import br.com.wsworks.listcarswswork.model.api.Car
import br.com.wsworks.listcarswswork.model.database.LeadsModel
import br.com.wsworks.listcarswswork.repository.Cars.CarsRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListCarViewModel(application: Application) : ViewModel() {

    private val _listCars = MutableStateFlow<List<Car>>(emptyList())
    val listCarsState = _listCars.asStateFlow()
    private val useremail= FirebaseAuth.getInstance().currentUser?.email

    private val _mCarRepository by lazy {
        CarsRepository(application.applicationContext)
    }


    fun getListCars() {

        viewModelScope.launch {

            try {

                val listCarAPi = WsWorksApi.createService(Endpoints::class.java)
                val response = listCarAPi.getListCars()

                if (response.isSuccessful) {
                    _listCars.value = response.body()?.cars ?: emptyList()
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    fun save(car: Car) {
        viewModelScope.launch {

            val leadssaved = LeadsModel(

                car.id,
                car.timestamp_cadastro,
                car.modelo_id,
                car.ano,
                car.combustivel,
                car.num_portas,
                car.cor,
                car.nome_modelo,
                car.valor,
                useremail.toString()

            )

            _mCarRepository.save(leadssaved)

        }
    }

}