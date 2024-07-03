package br.com.wsworks.listcarswswork.repository.Cars

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.wsworks.listcarswswork.model.database.LeadsModel

@Dao
interface ILeadsDAO{

    @Insert
    fun save (name: LeadsModel):Long

    @Update
    fun update (id:LeadsModel):Int

    @Query("SELECT * FROM Leads")
    fun getAll():List<LeadsModel>
}