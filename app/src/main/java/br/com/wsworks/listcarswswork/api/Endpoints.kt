package br.com.wsworks.listcarswswork.api

import br.com.wsworks.listcarswswork.model.api.ListCarsModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Endpoints {

    companion object {
        private const val LIST_CARS_ENDPOINT = "cars.json"
        private const val POST_CAR_LEADS = "cars/leads"
    }

    @GET(LIST_CARS_ENDPOINT)
   suspend fun getListCars(): Response<ListCarsModel>

   @POST(POST_CAR_LEADS)
   suspend fun postLeads(@Body car: String): Response<String>

}