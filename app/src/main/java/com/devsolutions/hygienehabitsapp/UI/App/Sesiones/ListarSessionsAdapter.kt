package com.devsolutions.hygienehabitsapp.UI.App.Sesiones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.SessionModel
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.Reportes.ListarReportesAdapter

class ListarSessionsAdapter(val sessionsList: ArrayList<SessionModel>,val layout:Int):RecyclerView.Adapter<ListarSessionsAdapter.ViewHolder>() {

    class ViewHolder(v: View):RecyclerView.ViewHolder(v) {
        val tvSessionDate = v.findViewById<TextView>(R.id.descriptionsSessionDate)
        val tvPlayedTime = v.findViewById<TextView>(R.id.descriptionsSessionPlayingTime)
        val btnShowMore = v.findViewById<CardView>(R.id.cardSession)

        fun bind(sessionModel: SessionModel) {
            tvSessionDate.setText(sessionModel.dateStart)
            tvPlayedTime.setText(sessionModel.dateEnd)
            btnShowMore.setOnClickListener{
                Component.showMessage(it.context, "Clicked on session: ${sessionModel.idSesion}")
                //Show fragment for list reports by session

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sessionsList[position])
    }

    override fun getItemCount(): Int {
        return sessionsList.size
    }
}