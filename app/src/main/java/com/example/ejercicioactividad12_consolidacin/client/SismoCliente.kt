package com.example.ejercicioactividad12_consolidacin.client

import com.example.ejercicioactividad12_consolidacin.service.SismoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SismoCliente {

    companion object{
        private val url = "https://api-sismologia-chile.herokuapp.com/"

        fun obtenCliente(): SismoService{
            val retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(
                GsonConverterFactory.create()).build()
            return retrofit.create(SismoService::class.java)
        }
    }
}