package com.example.ejercicioactividad12_consolidacin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioactividad12_consolidacin.R
import com.example.ejercicioactividad12_consolidacin.databinding.ItemRecyclerviewBinding
import com.example.ejercicioactividad12_consolidacin.model.SismosModel
import com.squareup.picasso.Picasso

class AdaptadorRV() : RecyclerView.Adapter<AdaptadorRV.CustomViewHolder>() {

    private var lista: List<SismosModel> = ArrayList()
    private lateinit var miListener: alClickearItemRV

    class CustomViewHolder(
        private val binding: ItemRecyclerviewBinding,
        private val listener: alClickearItemRV
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(img: SismosModel) {
            //Picasso.get().load(img.img_src).into(binding.ivMapa)

            Picasso.get().load(img.mapa).fit().centerCrop()
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder_error)
                .into(binding.ivMapa)
            binding.itemCard.setOnClickListener {

                listener.itemClick(adapterPosition)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), miListener
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setSismos(sismos: List<SismosModel>) {
        lista = sismos as ArrayList<SismosModel>
        notifyDataSetChanged()
    }

    interface alClickearItemRV {

        fun itemClick(position: Int)

    }

    fun setearListener(listener: alClickearItemRV) {

        miListener = listener
    }

}