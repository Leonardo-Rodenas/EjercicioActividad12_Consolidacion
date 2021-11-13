package com.example.ejercicioactividad12_consolidacin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicioactividad12_consolidacin.R
import com.example.ejercicioactividad12_consolidacin.adapter.AdaptadorRV
import com.example.ejercicioactividad12_consolidacin.databinding.FragmentListarBinding
import com.example.ejercicioactividad12_consolidacin.viewmodel.Factory
import com.example.ejercicioactividad12_consolidacin.viewmodel.SismosViewModel

class ListarFragment : Fragment() {

    private var _binding: FragmentListarBinding? = null
    private val binding get() = _binding!!
    private lateinit var vmodel:SismosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarBinding.inflate(inflater, container, false)

        vmodel = Factory(requireActivity().application).create(SismosViewModel::class.java)

        var adapter = AdaptadorRV()

        with(binding)
        {

            rvSismos.layoutManager = LinearLayoutManager(context)
            rvSismos.adapter = adapter

            Log.v("imgagenesRV", "Imagenes estan?")
            vmodel.traemeLoDelServer()

            adapter.setearListener(object : AdaptadorRV.alClickearItemRV {
                override fun itemClick(position: Int) {
                    //hey listen!!! poner acá lo que quiero que haga al clickear




                    findNavController().navigate(R.id.action_listarFragment_to_detalleFragmentFragment)
                }
            })
        }

        vmodel.exponeSismosDeDB().observe(viewLifecycleOwner, Observer {

            Log.d("RecyclerViewImagenes", it.toString())
            adapter.setSismos(it)

        })
        return binding.root
    }
}