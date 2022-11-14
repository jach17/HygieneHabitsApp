package com.devsolutions.hygienehabitsapp.UI.App

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Domain.JugadorUseCase
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.Adapter.ViewPagerAdapter
import com.devsolutions.hygienehabitsapp.UI.App.Jugadores.JugadoresFragment
import com.devsolutions.hygienehabitsapp.UI.App.MiInformacion.MostrarMiInfromacionFragment
import com.devsolutions.hygienehabitsapp.UI.App.Niveles.ListarNivelesFragment
import com.devsolutions.hygienehabitsapp.UI.App.Sesiones.ListarSesionesFragment
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment
import com.devsolutions.hygienehabitsapp.databinding.ActivityHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeActivityViewModel: HomeActivityViewModel
    private val splash = SplashFragment()
    private lateinit var selectJugadoresFragment: JugadoresFragment
    private var idPlayerSelected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        homeActivityViewModel = HomeActivityViewModel()
        selectJugadoresFragment = JugadoresFragment(homeActivityViewModel)
        setContentView(binding.root)
        splash.show(supportFragmentManager, "SPLASH")
        initView(homeActivityViewModel.getIdPlayer())
        initObservables()
    }

    private fun initObservables() {

        homeActivityViewModel.playerSelected.observe(this, Observer {
            binding.tvPlayerSelectedName.text = it.namePlayer
        })

        homeActivityViewModel.idPlayerSelected.observe(this, Observer { idPlayerSelected ->
            splash.dismiss()
            initView(idPlayerSelected)
        })
    }


    private fun initView(idPlayer: Int) {
        Toast.makeText(this, "Player id: $idPlayer", Toast.LENGTH_SHORT).show()
        if (idPlayer == 0) {
            showJugadoresList()
        } else {
            showTabs(idPlayer)
            homeActivityViewModel.getPlayerById(idPlayer)
        }
    }

    private fun showJugadoresList() {
        selectJugadoresFragment.show(supportFragmentManager, "SELECT JUGADORES")
    }

    private fun showTabs(idPlayer: Int) {
        selectJugadoresFragment.dismiss()
        initTabs(idPlayer)
    }

    private fun initTabs(idPlayer: Int) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ListarNivelesFragment(idPlayer), "Niveles")
        adapter.addFragment(ListarSesionesFragment(idPlayer), "Sesiones")
        adapter.addFragment(MostrarMiInfromacionFragment(idPlayer), "Mi informacion")
        val viewer = binding.viewPager
        viewer.adapter = adapter
        val tabs = binding.tabs
        tabs.setupWithViewPager(viewer)
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_niveles)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_session)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_miinfo)
    }
}

class HomeActivityViewModel : ViewModel() {
    val idPlayerSelected = MutableLiveData<Int>()
    val playersByTutorId = MutableLiveData<ArrayList<JugadorModel>>()
    val jugadorUseCase = JugadorUseCase()
    val playerSelected = MutableLiveData<JugadorModel>()

    fun getPlayerById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val player = jugadorUseCase.getPlayersById(id)[0]
            playerSelected.postValue(player)

        }
    }


    fun getPlayersByTutorId(tutorId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            playersByTutorId.postValue(jugadorUseCase.getPlayersFromTutorId(tutorId))
        }
    }

    fun setIdPlayer(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            idPlayerSelected.postValue(id)
        }
    }

    fun getIdPlayer(): Int {
        return idPlayerSelected.value ?: 0
    }


}