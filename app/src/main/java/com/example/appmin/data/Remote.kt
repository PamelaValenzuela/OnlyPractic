package com.example.appmin.data

import com.example.appmin.data.dataClass.PokemonDetailPV
import com.example.appmin.data.dataClass.PokemonPV
import com.example.appmin.detail.DetailFragmentPV
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

//https://lapi-pokemon.herokuapp.com/pokemon
//https://lapi-pokemon.herokuapp.com/pokemon/1

interface PokeAPIPV {

    @GET("pokemon")
    suspend fun getPokemonesPV(): Response<List<PokemonPV>>

    @GET("pokemon/{pid}")
    suspend fun getObjPokemon(@Path("pid") id: String): Response<PokemonDetailPV>
}

class RetrofitClientPV {

    companion object {
        private const val BASE_URL = "https://lapi-pokemon.herokuapp.com/"

        fun retrofitInstance(): PokeAPIPV {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PokeAPIPV::class.java)
        }
    }
}