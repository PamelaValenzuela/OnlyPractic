package com.example.appmin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmin.data.RetrofitClientPV
import com.example.appmin.data.dataClass.PokemonDetailPV
import com.example.appmin.data.dataClass.PokemonPV
import kotlinx.coroutines.launch

class PokeViewModelPV: ViewModel(){

    private val pokeListpv = MutableLiveData<List<PokemonPV>>()

    fun pokelistfunpv() : LiveData<List<PokemonPV>> = pokeListpv



    fun getPokeVMPV(){
        viewModelScope.launch {

            val mReponseVM = RetrofitClientPV.retrofitInstance().getPokemonesPV()
            Log.d("PokeViewModel", "cargando info")

            mReponseVM.let {
                when(it.isSuccessful){
                    true ->pokeListpv.value= mReponseVM.body()
                    false ->Log.d("pokeViewModel", "epa! error")
                }
            }

        }
    }


    private val mDetail = MutableLiveData<PokemonDetailPV>()
    fun getDetail(): LiveData<PokemonDetailPV> = mDetail


    fun getObjDetailVM(id: String) {

        // parchamos por culpa de API "·$"·$"%·!
        val pid = id.replace("#", "").toInt() - 1

        viewModelScope.launch {
            val mResponseOnePoke= RetrofitClientPV.retrofitInstance().getObjPokemon(pid.toString())

            if(mResponseOnePoke.isSuccessful) {
                mDetail.value = mResponseOnePoke.body()
            } else {
                Log.d("PokeViewModel", "epa! error en el detalle ${mResponseOnePoke.errorBody()}")
            }


        }

    }

    private lateinit var mSelectedID : PokemonPV

    fun setSelectedVM(pokemon: PokemonPV) {
        mSelectedID = pokemon
    }

    fun getSelectedVM() = mSelectedID

}
