package com.example.appmin.listing

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmin.PokeViewModelPV
import com.example.appmin.R
import com.example.appmin.databinding.FragmentListingBinding
import com.example.appmin.detail.DetailFragmentPV

class ListingFragment: Fragment() {

    private val mPokeViewModelF: PokeViewModelPV by activityViewModels()

    private lateinit var mBindingFRAG: FragmentListingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBindingFRAG = FragmentListingBinding.inflate(inflater)

        val mAdapterLF = PokeAdapterPV()
        mBindingFRAG.recyclerlayoutPV.adapter= mAdapterLF

        mBindingFRAG.recyclerlayoutPV.layoutManager= LinearLayoutManager(context)

      //  mBindingFRAG.recyclerlayoutPV.layoutManager= GridLayoutManager(context,1)
      //  binding.pokeList.adapter = adapter
        // OJO, pestaña y ceja -> si no se ve la info en el recyclerview
        //binding.pokeList.layoutManager = GridLayoutManager(context, 1)


        mPokeViewModelF.pokelistfunpv().observe(viewLifecycleOwner,{
            Log.d("ListingFragment", "actualizando info de pokemons ${it.size}")
                mAdapterLF.fUpdateAdapter(it)
        })
        mAdapterLF.selectedItemFAdapter().observe(viewLifecycleOwner,{
            Log.d("ListingFragment", "elemento seleccionado $it")
            mPokeViewModelF.setSelectedVM(it)

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container,DetailFragmentPV())?.addToBackStack("detail")?.commit()
        })

        return mBindingFRAG.root
    }
}