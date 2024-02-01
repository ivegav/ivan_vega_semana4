package com.iacc.ivan_vega_semana4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.iacc.ivan_vega_semana4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var camaras = ArrayList<Camara>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        for (i in 1..10) {
            camaras.add(Camara())
        }

        val listview: ListView = findViewById(R.id.listaCamaras)

        val arrayAdapter = MyAdapter(this, camaras)
        listview.adapter = arrayAdapter

        registerForContextMenu(listview)
        listview.setOnItemLongClickListener { parent, view, position, id ->
            openContextMenu(binding.listaCamaras.getChildAt(position))
            true
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_contextual, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val posicion = info.position

        return when (item.itemId) {
            R.id.optEliminar -> {
                camaras.removeAt(posicion)
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }
}