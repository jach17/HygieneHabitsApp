package com.devsolutions.hygienehabitsapp.UI.App.Reportes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.R

class ListarReportesAdapter(val reportList: ArrayList<ReporteModel>, val layout:Int) : RecyclerView.Adapter<ListarReportesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textLevel = itemView.findViewById<TextView>(R.id.descriptionsName)
        val textProgress = itemView.findViewById<TextView>(R.id.nivelProgress)
        val textMaxScore = itemView.findViewById<TextView>(R.id.descriptionsAge)
        val textPlayingTime = itemView.findViewById<TextView>(R.id.nivelPlayingTime)

        fun bind(reporteModel: ReporteModel) {
            textLevel.text = reporteModel.descriptionTitle
            textProgress.text = reporteModel.currentScoreLevel
            textMaxScore.text = reporteModel.currentScoreLevel
            textPlayingTime.text = reporteModel.dateEndLevel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reportList[position])
    }

    override fun getItemCount(): Int {
        return reportList.size
    }
}