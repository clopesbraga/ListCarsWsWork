package br.com.wsworks.listcarswswork.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wsworks.listcarswswork.api.Endpoints
import br.com.wsworks.listcarswswork.api.WsWorksApi
import br.com.wsworks.listcarswswork.model.database.LeadsModel
import br.com.wsworks.listcarswswork.repository.Cars.CarsRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch


class LeadsViewModel(application:Application): ViewModel() {

    private val _mleadsRepository by lazy {
        CarsRepository(application.applicationContext)
    }


    fun sendLeads() {
        viewModelScope.launch {
          val alleads =  _mleadsRepository.getAlleads()
            sendLeadsToAPI(alleads)
        }
    }

    suspend fun sendLeadsToAPI(allleads:List<LeadsModel>){
        val postCars = WsWorksApi.createService(Endpoints::class.java)
        val gson = Gson()
        val requestBodyJson = gson.toJson(allleads)
        Log.d("POST_REQUEST_BODY", requestBodyJson)

        val response = postCars.postLeads(requestBodyJson)
        if (response.isSuccessful) {
            Log.d("POST", "POST request successful")

        } else {
            Log.d(
                "POST_ERROR", "POST request failed with code " +
                        "${response.code()}: ${response.errorBody()?.string()}"
            )
        }
    }

}