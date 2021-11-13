package com.example.ejercicioactividad12_consolidacin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.ejercicioactividad12_consolidacin.database.SismosDatabase
import com.example.ejercicioactividad12_consolidacin.model.SismosModel
import com.example.ejercicioactividad12_consolidacin.repository.SismosRepositorio

class SismosViewModel(application: Application) : AndroidViewModel(application) {

    private var repositorio: SismosRepositorio

    init {

        val sismosDao = SismosDatabase.crearDatabase(application).obtenSismosDelDao()
        repositorio = SismosRepositorio(sismosDao)

    }

    fun traemeLoDelServer() {
        repositorio.obtenDataDelServer()
    }

    fun exponeSismosDeDB(): LiveData<List<SismosModel>> {
        return repositorio.exponeSismosDeLaBaseDeDatos()
    }

    fun exponeSismosFavoritosDeDB(): LiveData<List<SismosModel>> {
        return repositorio.exponeFavoritosDeLaBaseDeDatos()
    }

    fun cambiaeEstadoDeFavorito(sismo: SismosModel) {
        repositorio.cambiaeEstadoDeFavorito(sismo)
    }

    fun borraSismosFavoritosDeDB() {
        repositorio.borrarFavoritosDeLaBaseDeDatos()
    }

}