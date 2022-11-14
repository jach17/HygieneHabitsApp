package com.devsolutions.hygienehabitsapp.UI.App.Niveles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment
import com.devsolutions.hygienehabitsapp.databinding.FragmentListarNivelesBinding

class ListarNivelesFragment(val homeViewModel:HomeActivityViewModel) : Fragment() {
    private lateinit var _binding: FragmentListarNivelesBinding
    private val binding get() = _binding
    private lateinit var viewModelNiveles:NivelesViewModel
    private val splash = SplashFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarNivelesBinding.inflate(layoutInflater, container, false)
        splash.show(parentFragmentManager, "SPLASH")
        Toast.makeText(requireContext(), "Using ${homeViewModel.getIdPlayer()}", Toast.LENGTH_SHORT).show()
        viewModelNiveles = NivelesViewModel()
        viewModelNiveles.getReportsFromPlayerId(homeViewModel.getIdPlayer())
        viewModelNiveles.listReports.observe(this.viewLifecycleOwner, Observer {
            splash.dismiss()
            if(it.isNotEmpty()){
                initRecycler(it)
            }else{
                Toast.makeText(requireContext(), "Lista de reportes vacia", Toast.LENGTH_SHORT).show()
            }
        })
        return binding.root
    }


    private fun initRecycler(arrayList: ArrayList<ReporteModel>) {
        binding.rvListarNiveles.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvListarNiveles.adapter = ListarNivelesAdapter(arrayList, R.layout.item_nivel_card)

    }


}