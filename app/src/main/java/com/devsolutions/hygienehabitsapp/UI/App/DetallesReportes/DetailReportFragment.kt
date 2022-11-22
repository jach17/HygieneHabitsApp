package com.devsolutions.hygienehabitsapp.UI.App.DetallesReportes

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.databinding.FragmentDetailReportBinding
import com.echo.holographlibrary.PieGraph
import com.echo.holographlibrary.PieSlice
import kotlin.math.roundToInt

class DetailReportFragment(val reporteModel: ReporteModel) : DialogFragment() {

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



    private fun initView() {

        pieGrafica = binding.grafica


        var progr = 0f
        progr = calculateProgr(reporteModel)
        val total = 100f - progr
        binding.progressPc.text = "$progr %"
        graficar(progr, total)
    }

    private fun calculateProgr(reporteModel: ReporteModel): Float {
        val total = 5f // MAXIMA PUNTUACION
        val current = reporteModel.currentScoreLevel.toFloat() //CURRENT SCORE
        return (current * 100f) / total
    }


    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }
}