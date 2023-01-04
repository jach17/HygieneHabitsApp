package com.devsolutions.hygienehabitsapp.UI.App.Jugadores

import android.R.attr.label
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Core.SharedApp.Companion.prefs
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.UI.Login.View.MainActivity
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment
import com.devsolutions.hygienehabitsapp.databinding.FragmentJugadoresBinding


class JugadoresFragment(val homeActivityViewModel: HomeActivityViewModel) : DialogFragment() {
    private lateinit var _binding: FragmentJugadoresBinding
    private val binding get() = _binding
    private val splash = SplashFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJugadoresBinding.inflate(layoutInflater, container, false)
        splash.dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        splash.show(parentFragmentManager, "SPLASH")
        initObservables()
        homeActivityViewModel.getPlayersByTutorId(prefs.tutorId!!)
        return (binding.root)
    }

    private fun initObservables() {
        homeActivityViewModel.playersByTutorId.observe(this.viewLifecycleOwner, Observer {
            if (!it[0].namePlayer.isNullOrEmpty()) {
                initRecycler(it)
            } else {
                showEmptyRecyclerView()
            }
        })
    }

    private fun showEmptyRecyclerView() {
        splash.dismiss()
        binding.rvListarJugadores.apply {
            visibility = View.GONE
        }
        binding.tvJugadoresEmpty.apply {
            visibility = View.VISIBLE
        }
        binding.tvShowToken.apply {
            visibility = View.VISIBLE
            text = prefs.tutorToken
        }
        binding.btnOkAndClose.apply {
            visibility = View.VISIBLE
            setOnClickListener {
                Component.copiarTokenOnClipboard(requireContext(), prefs.tutorToken!!)

                requireActivity().finish()
            }
        }
        binding.btnLogout.apply {
            visibility = View.VISIBLE
            setOnClickListener {
                prefs.isLogged = false
                prefs.tutorToken=""
                prefs.tutorId=0
                navigateToActivity(requireContext(), MainActivity::class.java)
                requireActivity().finish()
            }
        }
    }



    private fun showFullRecyclerView() {
        splash.dismiss()
        binding.rvListarJugadores.apply {
            visibility = View.VISIBLE
        }
        binding.tvJugadoresEmpty.apply {
            visibility = View.GONE
        }
        binding.tvShowToken.apply {
            visibility = View.GONE
        }
        binding.btnOkAndClose.apply {
            visibility =View.GONE
        }
        binding.btnLogout.apply {
            visibility = View.GONE
        }
    }
    private fun navigateToActivity(context: Context, destine: Class<*>) {
        val intent = Intent(context, destine)
        startActivity(intent)
    }

    private fun initRecycler(arrayList: ArrayList<JugadorModel>) {
        showFullRecyclerView()

        binding.rvListarJugadores.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvListarJugadores.adapter =
            ListarJugadoresAdapter(arrayList, R.layout.item_jugador_card, homeActivityViewModel)
    }

}