package com.devsolutions.hygienehabitsapp.UI.App.Reportes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.ReportInfoDto
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.databinding.FragmentListarReportesBySessionDialogBinding

class ListarReportesBySessionDialogFragment(val homeActivityViewModel: HomeActivityViewModel) : DialogFragment() {

    private lateinit var _binding: FragmentListarReportesBySessionDialogBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarReportesBySessionDialogBinding.inflate(layoutInflater, container, false)
        initView()

        return binding.root
    }

    private fun initView() {
        Component.showMessage(requireContext(), "Show reports by session\nBtw, there is not a service for this feature xd")
    }
}