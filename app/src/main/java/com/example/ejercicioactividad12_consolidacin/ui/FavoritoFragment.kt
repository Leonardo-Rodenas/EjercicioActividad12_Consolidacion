package com.example.ejercicioactividad12_consolidacin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicioactividad12_consolidacin.R
import com.example.ejercicioactividad12_consolidacin.databinding.FragmentFavoritoBinding

class FavoritoFragment : Fragment() {

    private var _binding: FragmentFavoritoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritoBinding.inflate(inflater, container, false)
        return binding.root
    }

}