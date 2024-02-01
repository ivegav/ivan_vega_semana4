package com.iacc.ivan_vega_semana4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductoViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_view)

        val camara = intent.getSerializableExtra("camara") as? Camara

        if (camara != null) {

            findViewById<TextView>(R.id.txtNombreProducto).text = camara.nombre
            findViewById<TextView>(R.id.txtPrecio).text = camara.precio.toString()
            findViewById<TextView>(R.id.txtMarca).text = camara.marca
            findViewById<TextView>(R.id.txtModelo).text = camara.modelo
            Picasso.get().load(camara.imagen).into(findViewById<ImageView>(R.id.imgItem))

        }

        val btn = findViewById<TextView>(R.id.btnVolver)

        btn.setOnClickListener{
            finish()
        }


    }
}