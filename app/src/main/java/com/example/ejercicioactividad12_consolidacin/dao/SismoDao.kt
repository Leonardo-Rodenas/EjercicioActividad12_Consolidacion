package com.example.ejercicioactividad12_consolidacin.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ejercicioactividad12_consolidacin.model.SismosModel

@Dao
interface SismoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodosLosSismos(listaDeSismos: List<SismosModel>)

    @Query("SELECT * FROM tabla_sismos")
    fun obtenerTodosLosSismosDeLaBD(): LiveData<List<SismosModel>>

    //1 = true || 0 = false --> revisar las comillas o no
    @Query("SELECT * FROM tabla_sismos where favorito='1'")
    fun obtenerLosSismosFavoritosDeLaBD(): LiveData<List<SismosModel>>

    //ejecutado en consecuencia de si es favorito o no
    @Update
    fun cambiaEstadoFavorito (favorito: SismosModel)

    //este borra
    @Query("UPDATE tabla_sismos set favorito='0' where favorito='1'")
    fun borraFavorito ()

}
