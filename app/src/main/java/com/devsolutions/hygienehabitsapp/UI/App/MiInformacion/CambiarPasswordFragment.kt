package com.devsolutions.hygienehabitsapp.UI.App.MiInformacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.databinding.FragmentCambiarPasswordBinding

class CambiarPasswordFragment(val homeActivityViewModel: HomeActivityViewModel) : DialogFragment() {

    private lateinit var _binding:FragmentCambiarPasswordBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCambiarPasswordBinding.inflate(layoutInflater, container, false)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.btnGuardarNuevaPassword.setOnClickListener { saveNewPassword() }
    }

    private fun saveNewPassword() {
        Component.showMessage(requireContext(), "Do something")
        this.dismiss()
    }

    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }
}