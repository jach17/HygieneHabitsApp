package com.devsolutions.hygienehabitsapp.UI.App.MiInformacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment

class MostrarMiInfromacionFragment(val homeActivityViewModel: HomeActivityViewModel) : Fragment() {

    private val splash = SplashFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mostrar_mi_infromacion, container, false)
    }

    override fun onResume() {
        super.onResume()
        homeActivityViewModel.hideBtnPlayer()
    }


}