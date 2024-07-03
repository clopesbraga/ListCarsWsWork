package br.com.wsworks.listcarswswork.repository.Cars

import android.content.Context
import br.com.wsworks.listcarswswork.model.database.LeadsModel
import br.com.wsworks.listcarswswork.repository.AppDataBase

class CarsRepository(context : Context){

    private val base = AppDataBase.getDatabase(context).leadsDAO()

    fun save(nameCar: LeadsModel):Boolean= base.save(nameCar) > 0

    fun getAlleads():List<LeadsModel> = base.getAll()

}