package com.example.appmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.appmin.databinding.ActivityMainBinding

/*
*
* [] Control de versiones
* [] view binding
*      [] activar (build.gradle app)
*      [ ] actualizar Activities y fragments con viewBinding
* [] MainActivity
*      [] fragment container view
* [] consumo de API
*      [] permiso de internet
*      [] clearTextTraffic si es https
*      [] dependencias retrofit
*      [] pojos
*      [] interfaz de operaciones
*      [] cliente retrofit
* [] ViewModel
* [] Listado
*      [] Fragmento de listado
*      [] layout
*      [] recycler view
*      [] adapter
*      [] Viewholder
*      [] item layout
*      [] enlazar las piezas
*      [ ] onclick en un elemento de listado
* [ ] detalle
*      [] fragmento de detalle
*      [] layout
*      [] viewBinding
*      [ ] observar la info del pokemon para detalle
*      [ ] consumo de imágenes
*
* [ ] ROOM
*      [ ] interfaz de operaciones (DAO)
*      [ ] pojos (entities)
*      [ ] cliente
*/
class MainActivity : AppCompatActivity() {

    val objetoviewmodel : PokeViewModelPV by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

            objetoviewmodel.getPokeVMPV()

    }
}