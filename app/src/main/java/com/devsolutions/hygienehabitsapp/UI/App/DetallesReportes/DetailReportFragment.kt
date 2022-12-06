package com.devsolutions.hygienehabitsapp.UI.App.DetallesReportes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.FullReportDto
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.databinding.FragmentDetailReportBinding
import com.echo.holographlibrary.PieGraph
import com.echo.holographlibrary.PieSlice

class DetailReportFragment(val reportInfo: FullReportDto) : DialogFragment() {

    private lateinit var _binding: FragmentDetailReportBinding
    private val binding get() = _binding

    private lateinit var pieGrafica: PieGraph


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailReportBinding.inflate(layoutInflater, container, false)

        initView()
        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.btnHideDetails.setOnClickListener { hideDetails() }
    }

    private fun hideDetails() {
        Component.showMessage(requireContext(), "Done")
        this.dismiss()
    }

    fun graficar(drawSlice: Float, total: Float) {
        val sliceProgress = PieSlice()
        sliceProgress.color = activity?.resources?.getColor(R.color.colorNeutro)!!
        sliceProgress.value = drawSlice
        pieGrafica.addSlice(sliceProgress)

        val sliceTotal = PieSlice()
        sliceTotal.color = activity?.resources?.getColor(R.color.colorDark)!!
        sliceTotal.value = total
        pieGrafica.addSlice(sliceTotal)


    }


    @SuppressLint("SetTextI18n")
    private fun initView() {
        binding.tvLevelNumber.text = reportInfo.descriptionTitle
        binding.tvCurrentScore.text = reportInfo.currentScoreLevel
        binding.tvMaxScore.text= reportInfo.maxScore
        binding.tvPlayingTime.text = reportInfo.playingTime
        binding.tvSessionDate.text = reportInfo.dateStart

        binding.progressPc.text = "${reportInfo.progress} %"

        pieGrafica = binding.grafica
        graficar(reportInfo.progress, getTotal(reportInfo.progress))
    }

    private fun getTotal(progr: Float): Float {
        return 100f - progr
    }



    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }
}