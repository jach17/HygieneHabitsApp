package com.devsolutions.hygienehabitsapp.UI.App.Reportes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.FullReportDto
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment
import com.devsolutions.hygienehabitsapp.databinding.FragmentListarReportesBinding

class ListarReportesFragment(val homeActivityViewModel: HomeActivityViewModel) : Fragment() {
    private lateinit var _binding: FragmentListarReportesBinding
    private val binding get() = _binding
    private lateinit var viewModelReportes: ReportesViewModel
    private val splash = SplashFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarReportesBinding.inflate(layoutInflater, container, false)
        viewModelReportes = ReportesViewModel()


        splash.show(parentFragmentManager, "SPLASH")
        viewModelReportes.getReportsFromPlayerId(homeActivityViewModel.getIdPlayer())

        initObservables()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        homeActivityViewModel.showBtnPlayer()
    }

    private fun initObservables() {
        viewModelReportes.listReports.observe(this.viewLifecycleOwner, Observer {
            splash.dismiss()
            if (it.isNotEmpty()) {
                initRecycler(it)
            } else {
                initEmptyView()
            }
        })
    }

    private fun initEmptyView() {
        binding.rvListarReportes.apply {
            visibility = View.GONE
        }
        binding.tvEmptyListView.apply {
            visibility = View.VISIBLE
        }
    }




    private fun initRecycler(reportsDto: ArrayList<FullReportDto>) {

        binding.tvEmptyListView.apply {
            visibility = View.GONE
        }
        binding.rvListarReportes.apply {
            visibility = View.VISIBLE
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter =
                ListarReportesAdapter(reportsDto, homeActivityViewModel, R.layout.item_report_card, parentFragmentManager)
        }
    }


}