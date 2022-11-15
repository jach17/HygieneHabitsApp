package com.devsolutions.hygienehabitsapp.UI.App.MiInformacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Core.SharedApp.Companion.prefs
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment
import com.devsolutions.hygienehabitsapp.databinding.FragmentMostrarMiInfromacionBinding

class MostrarMiInfromacionFragment(val homeActivityViewModel: HomeActivityViewModel) : Fragment() {

    private lateinit var _binding: FragmentMostrarMiInfromacionBinding
    private val binding get() = _binding
    private lateinit var miinfoViewModel: MiInformacionViewModel
    private val splash = SplashFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMostrarMiInfromacionBinding.inflate(layoutInflater, container, false)
        miinfoViewModel = MiInformacionViewModel()
        splash.show(parentFragmentManager, "SPLASH")

        miinfoViewModel.getTutorInfoById(prefs.tutorId!!)
        initView()
        initObservables()

        return binding.root
    }

    private fun initObservables() {
        miinfoViewModel.tutorInfo.observe(this.viewLifecycleOwner, Observer {
            splash.dismiss()
            binding.tvNameTutor.text = it.nameTutor
            binding.tvAgeTutor.text = it.ageTutor
        })
    }

    private fun initView() {

    }

    override fun onResume() {
        super.onResume()
        homeActivityViewModel.hideBtnPlayer()
    }


}