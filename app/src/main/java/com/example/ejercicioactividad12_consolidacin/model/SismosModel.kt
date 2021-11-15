package com.example.ejercicioactividad12_consolidacin.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "tabla_sismos")
data class SismosModel(

    //@PrimaryKey(autoGenerate = true)
    //val id: Int, //Agregada por mi para llevar una id --> estas basura me generaba los duplicados
    @PrimaryKey
    val horaLocal: String,
    val horaUtc: String,
    val latitud: String,
    val longitud: String,
    val magnitud: String,
    val mapa: String,
    val profundidad: String,
    val referencia: String,
    val favorito: Boolean = false//agregado por mí para guardar en favorito

) : Serializable