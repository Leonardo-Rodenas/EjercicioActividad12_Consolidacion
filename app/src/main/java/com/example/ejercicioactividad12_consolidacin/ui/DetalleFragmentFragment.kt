package com.example.ejercicioactividad12_consolidacin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ejercicioactividad12_consolidacin.R
import com.example.ejercicioactividad12_consolidacin.databinding.FragmentDetalleFragmentBinding
import com.example.ejercicioactividad12_consolidacin.viewmodel.Factory
import com.example.ejercicioactividad12_consolidacin.viewmodel.SismosViewModel
import com.squareup.picasso.Picasso

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

        var recuperoHoraSismo = arguments?.getSerializable("horaSismo")
        var recuperoLatitudSismo = arguments?.getSerializable("latitudSismo")
        var recuperoLongitudSismo = arguments?.getSerializable("longitudSismo")
        var recuperoProfundidadSismo = arguments?.getSerializable("profundidadSismo")
        var recuperoMagnitudSismo = arguments?.getSerializable("magnitudSismo")
        var recuperoReferenciaSismo = arguments?.getSerializable("referenciaSismo")
        var recuperoMapaSismo = arguments?.getSerializable("mapaSismo")

        binding.tvDetalleHora.text = recuperoHoraSismo.toString()
        binding.tvDetalleLatitud.text = recuperoLatitudSismo.toString()
        binding.tvDetalleLongitud.text = recuperoLongitudSismo.toString()
        binding.tvDetalleProfundidad.text = recuperoProfundidadSismo.toString()
        binding.tvDetalleMagnitud.text = recuperoMagnitudSismo.toString()
        binding.tvDetalleReferencia.text = recuperoReferenciaSismo.toString()

        Picasso.get().load(recuperoMapaSismo.toString()).fit().centerCrop()
            .placeholder(R.drawable.user_placeholder)
            .error(R.drawable.user_placeholder_error)
            .into(binding.ivMapaDetalle)

        binding.checkboxFavorito.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked){
                Toast.makeText(context, "Sismo agregado a favoritos", Toast.LENGTH_SHORT).show()
                vmodel
            }else{
                vmodel.borraSismosFavoritosDeDB()
                Toast.makeText(context, "Sismo quitado de favoritos", Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }

}