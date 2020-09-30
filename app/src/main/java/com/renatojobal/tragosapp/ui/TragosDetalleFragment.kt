package com.renatojobal.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.renatojobal.tragosapp.AppDatabase
import com.renatojobal.tragosapp.R
import com.renatojobal.tragosapp.data.DataSourceImpl
import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.domain.RepoImpl
import com.renatojobal.tragosapp.ui.viewmodel.MainViewModel
import com.renatojobal.tragosapp.ui.viewmodel.VMFactory
import kotlinx.android.synthetic.main.fragment_tragos_detalle.*


class TragosDetalleFragment : Fragment() {

    private lateinit var drink : Drink

    private val viewModel by viewModels<MainViewModel>{ VMFactory(
        RepoImpl(DataSourceImpl(AppDatabase.getDatabase(requireActivity().applicationContext)))) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable<Drink>("drink")!!
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tragos_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.image).centerCrop().into(img_trago)
        trago_title.text = drink.nombre
        trago_desc.text = drink.descripcion
        if(drink.hasAlcohol.equals("Non_Alcoholic")){
            txt_has_alcohol.text = "Bebida sin alcohol"
        }else{
            txt_has_alcohol.text = "Bebida con alcohol"
        }

        btn_guardar_trago.setOnClickListener{
            viewModel.guardarTrago(drink)
            Toast.makeText(requireContext(), "Se guardó el trago a favoritos",Toast.LENGTH_LONG).show()
        }


    }

}