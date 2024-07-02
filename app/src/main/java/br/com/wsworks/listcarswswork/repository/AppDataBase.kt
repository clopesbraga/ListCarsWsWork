package br.com.wsworks.listcarswswork.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.wsworks.listcarswswork.model.database.LeadsModel
import br.com.wsworks.listcarswswork.repository.Cars.ICarsDAO

@Database(entities = arrayOf(LeadsModel::class), version = 1)

abstract class AppDataBase : RoomDatabase() {

    abstract fun carsDAO(): ICarsDAO

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

private val MIGRATION: Migration = object : Migration(0, 1) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("DELETE FROM Cars")
    }

}
