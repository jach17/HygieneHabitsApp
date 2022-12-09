package com.devsolutions.hygienehabitsapp.UI.App.DetallesReportes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Core.Prefs
import com.devsolutions.hygienehabitsapp.Core.SharedApp.Companion.prefs
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.FullReportDto
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment
import com.devsolutions.hygienehabitsapp.databinding.FragmentDetailReportBinding
import com.echo.holographlibrary.PieGraph
import com.echo.holographlibrary.PieSlice

class DetailReportFragment(
    val reportInfo: FullReportDto,
    val homeActivityViewModel: HomeActivityViewModel
) : DialogFragment() {

    private lateinit var _binding: FragmentDetailReportBinding
    private val binding get() = _binding
    private lateinit var detailReportViewModel: DetailReportViewModel
    private val splash = SplashFragment()
    private lateinit var pieGrafica: PieGraph


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailReportBinding.inflate(layoutInflater, container, false)
        detailReportViewModel = DetailReportViewModel()
        initView()
        initListeners()
        initObservables()

        return binding.root
    }

    private fun initObservables() {
        detailReportViewModel.result.observe(this.viewLifecycleOwner, Observer {

            Component.showMessage(requireContext(), "It value: $it")

            splash.dismiss()
            this.dismiss()
        })
    }

    private fun initListeners() {
        binding.btnHideDetails.setOnClickListener { hideDetails() }
    }

    private fun hideDetails() {
        splash.show(parentFragmentManager, "SPLASH")
        //addTutorFeedback
        //detailReportViewModel.addTutorFeedbackOnReport(reportInfo.reportId, reportInfo.tutorFeedback)
        val feedbackString = binding.etAddComment.text.toString()
        detailReportViewModel.addTutorFeedbackOnReport(
            Integer.parseInt(reportInfo.idReport),
            feedbackString
        )
        homeActivityViewModel.getPlayersByTutorId(prefs.tutorId!!)

    }

    fun graficar(progressSlice: Float, restoSlice: Float) {
        try {
            //Component.showMessage(requireContext(), "Value de progress: ${progressSlice}\nValue de resto: ${restoSlice}")

            val sliceProgress = PieSlice()
            sliceProgress.color = activity?.resources?.getColor(R.color.colorNeutro)!!
            sliceProgress.value = progressSlice
            pieGrafica.addSlice(sliceProgress)

            if (restoSlice > 0f) {
                val sliceResto = PieSlice()
                sliceResto.color = activity?.resources?.getColor(R.color.colorLigth)!!
                sliceResto.value = restoSlice
                pieGrafica.addSlice(sliceResto)
            }

        } catch (e: Exception) {
            Component.showMessage(requireContext(), "Error jeje: ${e.message}")

        }


    }


    @SuppressLint("SetTextI18n")
    private fun initView() {
        binding.tvLevelNumber.text = reportInfo.descriptionTitle
        binding.tvCurrentScore.text = reportInfo.currentScoreLevel
        binding.tvMaxScore.text = reportInfo.maxScore
        binding.tvPlayingTime.text = reportInfo.playingTime
        binding.tvSessionDate.text = reportInfo.dateStart
        binding.etAddComment.apply {
            setText(reportInfo.tutorFeedback)
        }
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