package com.devsolutions.hygienehabitsapp.UI.App.Reportes

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
import com.devsolutions.hygienehabitsapp.databinding.FragmentListarReportesBinding

class ListarReportesFragment(val homeActivityViewModel:HomeActivityViewModel) : Fragment() {
    private lateinit var _binding: FragmentListarReportesBinding
    private val binding get() = _binding
    private lateinit var viewModelNiveles:ReportesViewModel
    private val splash = SplashFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarReportesBinding.inflate(layoutInflater, container, false)
        viewModelNiveles = ReportesViewModel()


        splash.show(parentFragmentManager, "SPLASH")
        viewModelNiveles.getReportsFromPlayerId(homeActivityViewModel.getIdPlayer())

        initObservables()
        return binding.root
    }
    override fun onResume() {
        super.onResume()
        homeActivityViewModel.showBtnPlayer()
    }

    private fun initObservables() {
        viewModelNiveles.listReports.observe(this.viewLifecycleOwner, Observer {
            splash.dismiss()
            if(it.isNotEmpty()){
                initRecycler(it)
            }else{
                Toast.makeText(requireContext(), "Lista de reportes vacia", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun initRecycler(arrayList: ArrayList<ReporteModel>) {
        binding.rvListarReportes.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvListarReportes.adapter = ListarReportesAdapter(arrayList, R.layout.item_report_card, parentFragmentManager)
    }


}