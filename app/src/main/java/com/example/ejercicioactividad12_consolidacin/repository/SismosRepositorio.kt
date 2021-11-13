package com.example.ejercicioactividad12_consolidacin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.ejercicioactividad12_consolidacin.client.SismoCliente
import com.example.ejercicioactividad12_consolidacin.dao.SismoDao
import com.example.ejercicioactividad12_consolidacin.model.SismosModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SismosRepositorio(private val sismosDao: SismoDao) {

    private val service = SismoCliente.obtenCliente()
    val miLiveData = sismosDao.obtenerTodosLosSismosDeLaBD()

    //De Api a la base de datos
    fun obtenDataDelServer() {
        val call = service.obtenerSismos()
        call.enqueue(object : Callback<List<SismosModel>> {
            override fun onResponse(
                call: Call<List<SismosModel>>,
                response: Response<List<SismosModel>>
            ) {
                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let {
                        Log.v("logenrepo", response.body().toString())
                        sismosDao.insertarTodosLosSismos(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<SismosModel>>, t: Throwable) {
                call.cancel()
            }

        })
    }

    //para mostrar los sismos en la base de datos
    fun exponeSismosDeLaBaseDeDatos(): LiveData<List<SismosModel>> {
        return sismosDao.obtenerTodosLosSismosDeLaBD()
    }

    //para mostrar los FAVORITOS en la base de datos
    fun exponeFavoritosDeLaBaseDeDatos(): LiveData<List<SismosModel>> {
        return sismosDao.obtenerLosSismosFavoritosDeLaBD()
    }

    //este cambia el estado de si es favorito o no, pero tendria que cambiarlo acá no? o en el viewmodel?
    fun cambiaeEstadoDeFavorito(sismo:SismosModel){
        sismosDao.cambiaEstadoFavorito(sismo)

    }

    //para BORRAR los FAVORITOS en la base de datos
    fun borrarFavoritosDeLaBaseDeDatos() {
        sismosDao.borraFavorito()
    }

}