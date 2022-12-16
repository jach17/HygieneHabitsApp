package com.devsolutions.hygienehabitsapp.UI.App

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.MenuRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Core.SharedApp.Companion.prefs
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.Domain.JugadorUseCase
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.ViewAdapter.ViewPagerAdapter
import com.devsolutions.hygienehabitsapp.UI.App.Jugadores.JugadoresFragment
import com.devsolutions.hygienehabitsapp.UI.App.MiInformacion.MostrarMiInfromacionFragment
import com.devsolutions.hygienehabitsapp.UI.App.Reportes.ListarReportesFragment
import com.devsolutions.hygienehabitsapp.UI.App.Sesiones.ListarSesionesFragment
import com.devsolutions.hygienehabitsapp.UI.Login.View.MainActivity
import com.devsolutions.hygienehabitsapp.UI.Splash.SplashFragment
import com.devsolutions.hygienehabitsapp.databinding.ActivityHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeActivityViewModel: HomeActivityViewModel
    private val splash = SplashFragment()
    private lateinit var selectJugadoresFragment: JugadoresFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        homeActivityViewModel = HomeActivityViewModel()
        selectJugadoresFragment = JugadoresFragment(homeActivityViewModel)

        splash.show(supportFragmentManager, "SPLASH")

        initView(homeActivityViewModel.getIdPlayer())
        initObservables()
        initListeners()
        setContentView(binding.root)
    }

    private fun initMenu(view: View) {
        showMenu(view, R.menu.menu)
    }

    private fun showMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(applicationContext, v)
        popup.menuInflater.inflate(menuRes, popup.menu)
        popup.setOnMenuItemClickListener(::manageItemClick)
        popup.show()
    }

    private fun manageItemClick(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.menu_logout -> {
                prefs.isLogged = false
                prefs.tutorToken=""
                prefs.tutorId=0
                navigateToActivity(this, MainActivity::class.java)
                finish()
                true
            }
            else -> false
        }
    }

    private fun navigateToActivity(context: Context, destine: Class<*>) {
        val intent = Intent(context, destine)
        startActivity(intent)
    }

    private fun initListeners() {
        binding.btnMostrarJugador.setOnClickListener {
            homeActivityViewModel.setIdPlayer(Component.EMPTY_ID)
        }
        binding.btnShowMenu.setOnClickListener { initMenu(it) }
    }

    private fun initObservables() {



        homeActivityViewModel.showBtnChangePlayer.observe(this, Observer{
            if(it){
                binding.tvPlayerSelected.apply {
                    visibility = View.VISIBLE
                }
            }else{
                binding.tvPlayerSelected.apply {
                    visibility = View.GONE
                }
            }
        })

        homeActivityViewModel.playerSelected.observe(this, Observer {
            if(it!=null){
                binding.tvPlayerSelectedName.text = it.namePlayer
            }else{
                //Show dialog info
                Component.showMessage(applicationContext, "Ocurrió un error al seleccionar el jugador")
            }
        })

        homeActivityViewModel.idPlayerSelected.observe(this, Observer { idPlayerSelected ->
            splash.dismiss()
            initView(idPlayerSelected)
        })
    }

    private fun initView(idPlayer: Int) {

        if (idPlayer == Component.EMPTY_ID) {
            showJugadoresList()
        } else {
            showTabs()
            homeActivityViewModel.getPlayerById(idPlayer)
        }
    }

    private fun showJugadoresList() {
        selectJugadoresFragment.show(supportFragmentManager, "SELECT JUGADORES")
    }

    private fun showTabs() {
        selectJugadoresFragment.dismiss()
        initTabs()
    }

    private fun initTabs() {

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ListarReportesFragment(homeActivityViewModel))
        adapter.addFragment(ListarSesionesFragment(homeActivityViewModel))
        adapter.addFragment(MostrarMiInfromacionFragment(homeActivityViewModel))
        val viewer = binding.viewPager
        viewer.adapter = adapter

        val tabs = binding.tabs
        tabs.setupWithViewPager(viewer)

        tabs.getTabAt(0)!!.text = applicationContext.getString(R.string.reportes)
        tabs.getTabAt(1)!!.text = applicationContext.getString(R.string.sessions)
        tabs.getTabAt(2)!!.text = applicationContext.getString(R.string.miinfo)

    }
}

class HomeActivityViewModel : ViewModel() {
    val idPlayerSelected = MutableLiveData<Int>()
    val playersByTutorId = MutableLiveData<ArrayList<JugadorModel>>()
    val jugadorUseCase = JugadorUseCase()
    val playerSelected = MutableLiveData<JugadorModel>()
    val showBtnChangePlayer = MutableLiveData<Boolean>()


    fun showBtnPlayer(){
        showBtnChangePlayer.postValue(true)
    }

    fun hideBtnPlayer(){
        showBtnChangePlayer.postValue(false)
    }



    fun getPlayerById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val player = jugadorUseCase.getPlayersById(id)
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
        return idPlayerSelected.value ?: Component.EMPTY_ID
    }
}