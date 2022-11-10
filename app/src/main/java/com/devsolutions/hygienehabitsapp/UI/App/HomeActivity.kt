package com.devsolutions.hygienehabitsapp.UI.App

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.Adapter.ViewPagerAdapter
import com.devsolutions.hygienehabitsapp.UI.App.Jugadores.JugadoresFragment
import com.devsolutions.hygienehabitsapp.UI.App.MiInformacion.MostrarMiInfromacionFragment
import com.devsolutions.hygienehabitsapp.UI.App.Niveles.ListarNivelesFragment
import com.devsolutions.hygienehabitsapp.UI.App.Sesiones.ListarSesionesFragment
import com.devsolutions.hygienehabitsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initTabs()
        //initView()
        //initListeners()
    }

    private fun initTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(ListarNivelesFragment(), "Niveles")
        adapter.addFragment(ListarSesionesFragment(), "Sesiones")
        adapter.addFragment(MostrarMiInfromacionFragment(), "Mi informacion")
        adapter.addFragment(JugadoresFragment(), "Jugadores")

        val viewer = binding.viewPager
        viewer.adapter = adapter
        val tabs = binding.tabs
        tabs.setupWithViewPager(viewer)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_niveles)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_session)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_miinfo)
        tabs.getTabAt(3)!!.setIcon(R.drawable.ic_miinfo)


    }

    private fun initView() {
    }





    private fun initListeners() {

    }
}