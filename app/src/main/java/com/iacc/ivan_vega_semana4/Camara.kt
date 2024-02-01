package com.iacc.ivan_vega_semana4

import java.io.Serializable
import kotlin.random.Random

data class Camara(
    val nombre: String,
    val marca: String,
    val modelo: String,
    val resolucion: String,
    val precio: Int,
    val descripcion: String,
    val imagen: String
):Serializable{
    constructor() : this(
        generarNombre(),
        generarMarca(),
        generarModelo(),
        generarResolucion(),
        generarPrecio(),
        generarDescripcion(),
        generarImagen()
    )

    companion object {

        fun generarNombre(): String {
            val nombres =
                listOf("Camara de Seguridad", "Camara IP", "Camara CCTV", "Camara de Vigilancia")
            return nombres.random() + " ${Random.nextInt(100)}"
        }

        fun generarMarca(): String {
            val marcas = listOf(
                "Sony",
                "Samsung",
                "Panasonic",
                "Hikvision",
                "AOC",
                "Bosch",
                "LG",
                "Dahua",
                "Axis",
                "Vivotek"
            )
            return marcas.random()
        }

        fun generarModelo(): String {
            return "Modelo ${Random.nextInt(1000)}"
        }

        fun generarResolucion(): String {
            val resoluciones = listOf("HD", "Full HD", "4K")
            return resoluciones.random()
        }

        fun generarPrecio(): Int {
            return Random.nextInt(100, 1000)
        }

        fun generarDescripcion(): String {
            val descripciones = listOf(
                "Cámara de seguridad para exteriores",
                "Cámara domo para interiores",
                "Cámara con visión nocturna"
            )
            return descripciones.random()
        }

        fun generarImagen(): String {

            val imagenes = listOf(
                "https://www.pcfactory.cl/public/foto/48384/1_1000.jpg?t=1705595940308",
                "https://i.ebayimg.com/images/g/-wgAAOSw3KdkFEuU/s-l1600.png",
                "https://www.pcfactory.cl/public/foto/44483/1_1000.jpg?t=1705563231107"

            )

            return imagenes.random()
        }
    }
}