package com.devsolutions.hygienehabitsapp.UI.App.Sesiones

import android.animation.LayoutTransition
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.devsolutions.hygienehabitsapp.Core.Component
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.SessionWithReports
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.databinding.ItemSessionCardBinding

class ListarSessionsAdapter(
    val sessionsList: ArrayList<SessionWithReports>
) :
    RecyclerView.Adapter<ListarSessionsAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val binding = ItemSessionCardBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_session_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val item = sessionsList[position]
            descriptionsSessionDate.text = item.dateStart.split(" ")[Component.GET_DATE]
            val adapterReports = ListarReportesBySessionAdapter(item.reportsOfSession)
            rvReportsBySession.adapter = adapterReports
            layoutContainer.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

            cardSession.setOnClickListener {
                expand(rvReportsBySession, layoutContainer, it)
            }
        }
    }

    private fun expand(rvReports: RecyclerView, layout: LinearLayout, view: View) {
        val visibleState = if (rvReports.visibility == View.GONE) {
            View.VISIBLE
        } else {
            View.GONE
        }

        TransitionManager.beginDelayedTransition(layout, AutoTransition())
        rvReports.visibility = visibleState
    }


    override fun getItemCount(): Int {
        return sessionsList.size
    }
}