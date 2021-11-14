package com.example.ejercicioactividad12_consolidacin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicioactividad12_consolidacin.R
import com.example.ejercicioactividad12_consolidacin.adapter.AdaptadorRV
import com.example.ejercicioactividad12_consolidacin.databinding.FragmentListarBinding
import com.example.ejercicioactividad12_consolidacin.model.SismosModel
import com.example.ejercicioactividad12_consolidacin.viewmodel.Factory
import com.example.ejercicioactividad12_consolidacin.viewmodel.SismosViewModel
import java.io.Serializable

class ListarFragment : Fragment() {

    private var _binding: FragmentListarBinding? = null
    private val binding get() = _binding!!
    private lateinit var vmodel: SismosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarBinding.inflate(inflater, container, false)

        binding.progressBarr.visibility = View.VISIBLE
        binding.rvSismos.visibility = View.GONE

        vmodel = Factory(requireActivity().application).create(SismosViewModel::class.java)

        var adapter = AdaptadorRV()

        with(binding)
        {

            rvSismos.layoutManager = LinearLayoutManager(context)
            rvSismos.adapter = adapter

            Log.v("imgagenesRV", "Imagenes estan?")
            vmodel.traemeLoDelServer()

            adapter.setearListener(object : AdaptadorRV.alClickearItemRV {
                override fun itemClick(position: Int, sismoModelo : SismosModel) {
                    //lo que quiero que haga al clickear

                    var miBundle = Bundle()
                    miBundle.putSerializable("horaSismo", sismoModelo.horaLocal)
                    miBundle.putSerializable("latitudSismo", sismoModelo.latitud)
                    miBundle.putSerializable("longitudSismo", sismoModelo.longitud)
                    miBundle.putSerializable("profundidadSismo", sismoModelo.profundidad)
                    miBundle.putSerializable("magnitudSismo", sismoModelo.magnitud)
                    miBundle.putSerializable("referenciaSismo", sismoModelo.referencia)
                    miBundle.putSerializable("mapaSismo", sismoModelo.mapa)

                    findNavController().navigate(R.id.action_listarFragment_to_detalleFragmentFragment, miBundle)
                }
            })
        }



        vmodel.exponeSismosDeDB().observe(viewLifecycleOwner, Observer {

            Log.d("RecyclerViewImagenes", it.toString())
            adapter.setSismos(it)

            binding.progressBarr.visibility = View.GONE
            binding.rvSismos.visibility = View.VISIBLE

        })
        return binding.root
    }

}