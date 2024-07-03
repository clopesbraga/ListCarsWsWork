package br.com.wsworks.listcarswswork.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.wsworks.listcarswswork.model.database.LeadsModel
import br.com.wsworks.listcarswswork.repository.Cars.ILeadsDAO

@Database(entities = arrayOf(LeadsModel::class), version = 4)

abstract class AppDataBase : RoomDatabase() {

    abstract fun leadsDAO(): ILeadsDAO

    companion object {

        private lateinit var DBINSTANCE: AppDataBase
        fun getDatabase(context: Context): AppDataBase {
            if (!Companion::DBINSTANCE.isInitialized) {
                synchronized(AppDataBase::class) {
                    DBINSTANCE =
                        Room.databaseBuilder(context, AppDataBase::class.java, "AppDataBase")
                            .addMigrations(MIGRATION)
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return DBINSTANCE
        }


    }

}

private val MIGRATION: Migration = object : Migration(3, 4) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("DELETE FROM Leads")
    }

}
