package com.example.ejercicioactividad12_consolidacin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tabla_sismos")
data class SismosModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int, //Agregada por mi para llevar una id
    val horaLocal: String,
    val horaUtc: String,
    val latitud: String,
    val longitud: String,
    val magnitud: String,
    val mapa: String,
    val profundidad: String,
    val referencia: String,
    val favorito: Boolean //agregado por mí para guardar en favorito
)