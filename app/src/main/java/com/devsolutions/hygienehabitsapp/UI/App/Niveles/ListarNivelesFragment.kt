package com.devsolutions.hygienehabitsapp.UI.App.Niveles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.databinding.FragmentListarNivelesBinding

class ListarNivelesFragment : Fragment() {
    private lateinit var _binding: FragmentListarNivelesBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarNivelesBinding.inflate(layoutInflater, container, false)
        initView()
        return binding.root
    }

    fun getList():ArrayList<ReporteModel>{
        val list = arrayListOf<ReporteModel>()
        list.add(ReporteModel("name", "as", "as", "sgdfh", "sdg", "red"))
        list.add(ReporteModel("name", "as", "as", "sgdfh", "sdg", "red"))
        list.add(ReporteModel("name", "as", "as", "sgdfh", "sdg", "red"))

        return list
    }

    private fun initView() {
        binding.rvListarNiveles.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvListarNiveles.adapter = ListarNivelesAdapter(getList(), R.layout.item_nivel_card)

    }


}