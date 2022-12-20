package com.devsolutions.hygienehabitsapp.UI.App.Sesiones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.SessionModel
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.Reportes.ListarReportesAdapter

class ListarSessionsAdapter(val sessionsList: ArrayList<SessionModel>, val layout: Int, val sessionesViewModel: SessionesViewModel) :
    RecyclerView.Adapter<ListarSessionsAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvSessionDate = v.findViewById<TextView>(R.id.descriptionsSessionDate)
        val btnShowMore = v.findViewById<CardView>(R.id.cardSession)
        val rvReportsFromSessionId = v.findViewById<RecyclerView>(R.id.rvReportsBySession)


        fun bind(sessionModel: SessionModel, svm: SessionesViewModel) {
            svm.getReportsFromSessionId(sessionModel.idSesion)
            tvSessionDate.text = sessionModel.dateStart

            rvReportsFromSessionId.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = ListarReportesBySessionAdapter(svm.getListReportsBySession(), R.layout.item_session_card)
            }

            btnShowMore.setOnClickListener {
                Component.showMessage(
                    it.context,
                    "Card with id: ${sessionModel.idSesion} for calling reports"
                )

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sessionsList[position], sessionesViewModel)
    }

    override fun getItemCount(): Int {
        return sessionsList.size
    }
}