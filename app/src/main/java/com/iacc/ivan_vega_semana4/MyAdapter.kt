package com.iacc.ivan_vega_semana4

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.iacc.ivan_vega_semana4.databinding.ItemCamaraBinding
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Context, private val camaras: ArrayList<Camara>):BaseAdapter (){


    override fun getCount(): Int {
       return camaras.size
    }

    override fun getItem(position: Int): Any {
       return position
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        parent.isLongClickable = true
        val binding: ItemCamaraBinding
        val convertViewd: View
        if (convertView == null) {
            // Si convertView es nulo, inflar una nueva vista y crear el binding
            binding = ItemCamaraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            convertViewd = binding.root
            convertViewd.tag = binding // Guardar el binding en el tag de la vista
        } else {
            // Si convertView no es nulo, obtener el binding desde su tag
            binding = convertView.tag as ItemCamaraBinding
            convertViewd = convertView
        }

        // Asignar datos a la vista utilizando el binding
        binding.txtMarca.text = camaras[position].marca
        binding.txtNombre.text = camaras[position].nombre

        convertViewd.setOnClickListener{
            val intent = Intent(context, ProductoViewActivity::class.java)
            intent.putExtra("camara", camaras[position])
            context.startActivity(intent)
        }

        Picasso.get().load(camaras[position].imagen).into(binding.fotoCamara)

        return convertViewd
    }

}