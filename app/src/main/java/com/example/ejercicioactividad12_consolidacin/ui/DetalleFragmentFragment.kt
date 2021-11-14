package com.example.ejercicioactividad12_consolidacin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicioactividad12_consolidacin.R
import com.example.ejercicioactividad12_consolidacin.databinding.FragmentDetalleFragmentBinding
import com.example.ejercicioactividad12_consolidacin.viewmodel.Factory
import com.example.ejercicioactividad12_consolidacin.viewmodel.SismosViewModel

class DetalleFragmentFragment : Fragment() {

    private var _binding: FragmentDetalleFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var vmodel: SismosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetalleFragmentBinding.inflate(inflater, container, false)

        vmodel = Factory(requireActivity().application).create(SismosViewModel::class.java)







        return binding.root
    }

}