package com.devsolutions.hygienehabitsapp.UI.App.Jugadores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.Niveles.ListarNivelesAdapter
import com.devsolutions.hygienehabitsapp.databinding.FragmentJugadoresBinding

class JugadoresFragment : DialogFragment() {
    private lateinit var _binding:FragmentJugadoresBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJugadoresBinding.inflate(layoutInflater, container, false)
        initView()
        return (binding.root)
    }

    private fun initView() {
        if(!getList().isEmpty()){
            initRecycler()
        }else{
            binding.rvListarJugadores.apply {
                visibility = View.GONE
            }
            binding.tvJugadoresEmpty.apply {
                visibility = View.VISIBLE
            }

        }
    }

    private fun initRecycler(){
        binding.rvListarJugadores.apply {
            visibility = View.VISIBLE
        }
        binding.tvJugadoresEmpty.apply {
            visibility = View.GONE
        }

        binding.rvListarJugadores.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvListarJugadores.adapter = ListarJugadoresAdapter(getList(), R.layout.item_jugador_card)
    }

    fun getList():ArrayList<JugadorModel>{
        val list = arrayListOf<JugadorModel>()
/*
        list.add(
            JugadorModel(
            1,
            "jONT",
            "123",
            "12",
            1,
            "123ABC",
            1,
            0,
            0,
            0,
            0
        )
        )

 */

        return list
    }

}