package com.example.ejercicioactividad12_consolidacin.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Factory (private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((SismosViewModel::class.java))) {
            return SismosViewModel(application) as T
        }
        throw IllegalArgumentException("ViewModel Desconocido")
    }

}