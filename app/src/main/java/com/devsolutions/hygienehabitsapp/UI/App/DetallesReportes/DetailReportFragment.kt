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
            if (it != 0) {
                Component.showMessage(requireContext(), "Sending feedback")
                homeActivityViewModel.setIdPlayer(homeActivityViewModel.getIdPlayer())
            } else {
                Component.showMessage(requireContext(), "Something went wrong")
            }
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

        if(progressSlice!=100f) {
            setLevelUncompletedView()
            val sliceProgress = PieSlice()
            sliceProgress.color = activity?.resources?.getColor(R.color.colorNeutro)!!
            sliceProgress.value = progressSlice
            pieGrafica.addSlice(sliceProgress)

            val sliceResto = PieSlice()
            sliceResto.color = activity?.resources?.getColor(R.color.colorLigth)!!
            sliceResto.value = restoSlice
            pieGrafica.addSlice(sliceResto)
        }else{
            setLevelCompletedView()
        }

    }

    private fun setLevelCompletedView() {
        binding.grafica.apply {
            visibility = View.GONE
        }
        binding.ivLevelCompleted.apply {
            visibility = View.VISIBLE
        }
    }

    private fun setLevelUncompletedView(){
        binding.grafica.apply {
            visibility = View.VISIBLE
        }
        binding.ivLevelCompleted.apply {
            visibility = View.GONE
        }
    }


    @SuppressLint("SetTextI18n")
    private fun initView() {
        binding.tvLevelNumber.text = reportInfo.descriptionTitle
        binding.tvCurrentScore.text = reportInfo.currentScoreLevel
        binding.tvMaxScore.text = reportInfo.maxScore
        binding.tvPlayingTime.text = reportInfo.playingTime
        binding.tvSessionDate.text = reportInfo.dateStart
        binding.tvDescriptionLevel.text = (getLevelDescriptionsFromLevel(reportInfo.descriptionTitle)).toString()
        binding.etAddComment.apply {
            setText(reportInfo.tutorFeedback)
        }
        binding.progressPc.text = "${reportInfo.progress} %"

        pieGrafica = binding.grafica
        graficar(reportInfo.progress, getTotal(reportInfo.progress))
    }

    private fun getLevelDescriptionsFromLevel(descriptionTitle: String) {
        when(descriptionTitle){
            "Nivel 1" -> {
                "[Objetivo del nivel]"
            }
            "Nivel 2" ->{
                "[Objetivo del nivel]"
            }
            "Nivel 3" ->{
                "[Objetivo del nivel]"
            }
            "Nivel 4" ->{
                "[Objetivo del nivel]"
            }
            "Nivel 5" ->{
                "[Objetivo del nivel]"
            }

            else ->{
                "Ha ocurrido un error, por favor, reinicie su aplicación. "
            }

        }
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