package com.devsolutions.hygienehabitsapp.UI.App.DetallesReportes

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.databinding.FragmentDetailReportBinding
import com.echo.holographlibrary.PieGraph
import com.echo.holographlibrary.PieSlice
import kotlin.math.roundToInt

class DetailReportFragment(val reporteModel: ReporteModel) : DialogFragment() {

    private lateinit var _binding: FragmentDetailReportBinding
    private val binding get() = _binding

    private lateinit var pieGrafica: PieGraph

    private var listaContent = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailReportBinding.inflate(layoutInflater, container, false)

        initView()

        return binding.root
    }

    fun graficar(list:ArrayList<String>){
        for (item in list){
            val rebanada = PieSlice()
            rebanada.color = Color.parseColor(getRandomColor())
            rebanada.value = 25f
            pieGrafica.addSlice(rebanada)

        }
    }

    private fun getRandomColor(): String {
        val letras = arrayOf("0","1","2","3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")
        var color = "#"
        for(i in 0 .. 5){
            color+=letras[(Math.random()*15).roundToInt()]
        }
        return color
    }

    private fun initView() {

        pieGrafica = binding.grafica

        listaContent.add("Unomas")
        listaContent.add("Unomas")
        listaContent.add("Unomas")
        listaContent.add("Unomas")

        graficar(listaContent)
    }




    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }
}