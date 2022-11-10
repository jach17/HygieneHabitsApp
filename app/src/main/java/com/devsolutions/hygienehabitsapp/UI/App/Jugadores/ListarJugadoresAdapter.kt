package com.devsolutions.hygienehabitsapp.UI.App.Jugadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.JugadorModel
import com.devsolutions.hygienehabitsapp.R

class ListarJugadoresAdapter(val listJugadores:ArrayList<JugadorModel>,val  layout:Int):RecyclerView.Adapter<ListarJugadoresAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val textName:TextView = view.findViewById(R.id.titleNamePlayer)
        val textAge:TextView = view.findViewById(R.id.titlePlayerAge)
        val btn:ImageView = view.findViewById(R.id.btnShowMoreJugador)
        val context = view.context
        fun bind(jugador: JugadorModel) {
            textName.text = jugador.namePlayer
            textAge.text = jugador.agePlayer
            btn.setOnClickListener{
                Toast.makeText(context, "Clicked on id: ${jugador.idPlayer}", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listJugadores[position])
    }

    override fun getItemCount(): Int {
        return listJugadores.size
    }
}