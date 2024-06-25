package br.com.wsworks.listcarswswork.api

import br.com.wsworks.listcarswswork.model.ListCarsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {

    companion object {
        private const val LIST_CARS_ENDPOINT = "cars.json"
    }

    @GET(LIST_CARS_ENDPOINT)
   suspend fun getListCars(): Response<ListCarsModel>

}