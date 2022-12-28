package com.devsolutions.hygienehabitsapp.UI.App.Sesiones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.SessionWithReports
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.HomeActivityViewModel
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment
import com.devsolutions.hygienehabitsapp.databinding.FragmentListarSesionesBinding

class ListarSesionesFragment(val homeActivityViewModel: HomeActivityViewModel) : Fragment() {


    private lateinit var _binding: FragmentListarSesionesBinding
    private val binding get() = _binding
    private lateinit var listarSessionesViewModel: SessionesViewModel
    private val splash = SplashFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListarSesionesBinding.inflate(layoutInflater, container, false)
        listarSessionesViewModel = SessionesViewModel()


        splash.show(parentFragmentManager, "SPLASH")
        listarSessionesViewModel.getSessionsFromPlayerId(homeActivityViewModel.getIdPlayer())


        initObservables()


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        homeActivityViewModel.showBtnPlayer()
    }

    private fun initObservables() {
        listarSessionesViewModel.sessionsList.observe(this.viewLifecycleOwner, Observer {
            splash.dismiss()
            if (it[0].idSesion != 0) {
                initRecycler(it)
            } else {
                showEmptyView()
            }
        })
    }

    private fun showEmptyView() {
        binding.tvEmptyListView.apply {
            visibility = View.VISIBLE
        }
        binding.rvListarSessions.apply {
            visibility = View.GONE
        }
    }

    private fun initRecycler(arrayList: ArrayList<SessionWithReports>) {
        try {
            binding.tvEmptyListView.apply {
                visibility = View.GONE
            }
            binding.rvListarSessions.apply {
                visibility = View.VISIBLE
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = ListarSessionsAdapter(arrayList, R.layout.item_session_card)
            }
        } catch (e: Exception) {
            Component.showMessage(requireContext(), "Error en view list sessions fragment 84: ${e.message}")
        }
    }

}