package com.devsolutions.hygienehabitsapp.UI.Error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.databinding.FragmentOnErrorBinding

class OnErrorFragment(val error:String) : DialogFragment() {
    private lateinit var _binding: FragmentOnErrorBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnErrorBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvErrorDescription.apply {
            text = error
        }
        binding.btnError.apply {
            setOnClickListener {
                //CloseApp
                Component.showMessage(requireContext(), "Restart app")
            }
        }
    }
}