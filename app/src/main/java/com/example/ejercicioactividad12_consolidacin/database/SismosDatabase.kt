package com.example.ejercicioactividad12_consolidacin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ejercicioactividad12_consolidacin.dao.SismoDao
import com.example.ejercicioactividad12_consolidacin.model.SismosModel

@Database(entities = [SismosModel::class], version = 1)
abstract class SismosDatabase: RoomDatabase() {

    abstract fun obtenSismosDelDao(): SismoDao

    companion object {

        @Volatile
        private var baseDeDatosCreada: SismosDatabase? = null

        fun crearDatabase(context: Context): SismosDatabase {

            if (baseDeDatosCreada == null) {
                synchronized(this)
                {
                    baseDeDatosCreada = Room.databaseBuilder(
                        context,
                        SismosDatabase::class.java,
                        "base_De_Datos_Sismos"
                    ).build()
                }
            }
            return baseDeDatosCreada!!
        }
    }
}