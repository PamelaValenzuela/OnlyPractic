package com.example.appmin.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import coil.transform.CircleCropTransformation
import com.example.appmin.PokeViewModelPV
import com.example.appmin.databinding.FragmentDetailBinding

class DetailFragmentPV: Fragment() {

        private lateinit var mBidingDetail : FragmentDetailBinding

     private val mPokeViewModelDetail: PokeViewModelPV by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBidingDetail = FragmentDetailBinding.inflate(inflater)

        val mPokemonDetail= mPokeViewModelDetail.getSelectedVM()
        Log.d("DetailFragment", "$mPokemonDetail")

        mPokeViewModelDetail.getObjDetailVM(mPokemonDetail.id)

        mPokeViewModelDetail.getDetail().observe(viewLifecycleOwner,{
            mBidingDetail.textViewid.text= it.id
            mBidingDetail.textViewname.text= it.name
            mBidingDetail.imagedeldetail.load(it.img){
                transformations(CircleCropTransformation())
            }

        })


        return mBidingDetail.root
    }
}