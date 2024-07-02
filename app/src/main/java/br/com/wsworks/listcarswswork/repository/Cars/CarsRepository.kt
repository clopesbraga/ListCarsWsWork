package br.com.wsworks.listcarswswork.repository.Cars

import android.content.Context
import br.com.wsworks.listcarswswork.model.database.LeadsModel
import br.com.wsworks.listcarswswork.repository.AppDataBase

class CarsRepository(context : Context){

    private val base = AppDataBase.getDatabase(context).carsDAO()

    fun save(nameCar: LeadsModel):Boolean= base.save(nameCar) > 0

}