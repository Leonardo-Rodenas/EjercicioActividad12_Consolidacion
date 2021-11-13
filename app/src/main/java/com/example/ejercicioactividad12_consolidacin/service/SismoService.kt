package com.example.ejercicioactividad12_consolidacin.service

import com.example.ejercicioactividad12_consolidacin.model.SismosModel
import retrofit2.Call
import retrofit2.http.GET

interface SismoService {

    @GET
    fun obtenerSismos(): Call<List<SismosModel>>

}