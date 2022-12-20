package com.devsolutions.hygienehabitsapp.UI.App.Sesiones

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.FullReportFromSessionModel
import com.devsolutions.hygienehabitsapp.R

class ListarReportesBySessionAdapter(val listReportsBySession: ArrayList<FullReportFromSessionModel>, itemSessionCard: Int) : RecyclerView.Adapter<ListarReportesBySessionAdapter.ViewHolder>() {

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val levelPlayed:TextView = v.findViewById(R.id.tvLevelPlayedOnSession)
        val timePlayed:TextView = v.findViewById(R.id.tvTimePlayedOnSession)
        fun bind(fullReportFromSessionModel: FullReportFromSessionModel) {
            levelPlayed.text = fullReportFromSessionModel.descriptionTitle
            timePlayed.text = fullReportFromSessionModel.currentScoreLevel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listReportsBySession[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}
