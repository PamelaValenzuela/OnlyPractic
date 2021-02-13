package com.example.appmin.listing

import android.renderscript.ScriptGroup
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.appmin.data.dataClass.PokemonPV
import com.example.appmin.databinding.ItemHolderBinding

class PokeAdapterPV: RecyclerView.Adapter<PokeAdapterPV.PokeVHPV>() {

    private var pokelistAdapterPV = listOf<PokemonPV>()


    private val mSelectedItem = MutableLiveData<PokemonPV>()

    fun selectedItemFAdapter(): LiveData<PokemonPV> = mSelectedItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeVHPV {
        val mBindingOCVH = ItemHolderBinding
            .inflate(LayoutInflater.from(parent.context))

        return PokeVHPV(mBindingOCVH)
    }

    override fun onBindViewHolder(holder: PokeVHPV, position: Int) {
        val itemPokeOBVH = pokelistAdapterPV[position]

        holder.mBindDelContenedor(itemPokeOBVH)

       holder.itemView.setOnClickListener(){

            Log.d("PokeAdapter", "elemento seleccionado $itemPokeOBVH")
                mSelectedItem.value= itemPokeOBVH
        }

    }

    override fun getItemCount() = pokelistAdapterPV.size

    fun fUpdateAdapter(ppokelist: List<PokemonPV>) {
        pokelistAdapterPV = ppokelist
        notifyDataSetChanged()
    }

    class PokeVHPV(val mBindingVH: ItemHolderBinding) : RecyclerView.ViewHolder(mBindingVH.root) {

        fun mBindDelContenedor(nombreObjeto: PokemonPV) {
            mBindingVH.textViewname.text = nombreObjeto.name

        }

    }
}



