package br.com.wsworks.listcarswswork.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wsworks.listcarswswork.api.Endpoints
import br.com.wsworks.listcarswswork.api.ListCarsApi
import br.com.wsworks.listcarswswork.model.Car
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListCarViewModel : ViewModel() {

    private val _listCars = MutableStateFlow<List<Car>>(emptyList())
    val listCarsState = _listCars.asStateFlow()


    fun getListCars() {

        viewModelScope.launch {

            try {

                val listCarAPi = ListCarsApi.createService(Endpoints::class.java)
                val response = listCarAPi.getListCars()

                if (response.isSuccessful) {
                    _listCars.value = response.body()?.cars ?: emptyList()
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }


}