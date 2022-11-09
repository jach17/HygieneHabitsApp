package com.devsolutions.hygienehabitsapp.UI.App.Niveles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.ReporteModel
import com.devsolutions.hygienehabitsapp.R

class ListarNivelesAdapter(val reportList: ArrayList<ReporteModel>, val layout:Int) : RecyclerView.Adapter<ListarNivelesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textLevel = itemView.findViewById<TextView>(R.id.nivelDescription)
        val textProgress = itemView.findViewById<TextView>(R.id.nivelProgress)
        val textMaxScore = itemView.findViewById<TextView>(R.id.nivelMaxScore)
        val textPlayingTime = itemView.findViewById<TextView>(R.id.nivelPlayingTime)

        fun bind(reporteModel: ReporteModel) {
            textLevel.text = reporteModel.nivel
            textProgress.text = reporteModel.progress
            textMaxScore.text = reporteModel.maxScore
            textPlayingTime.text = reporteModel.playingtime
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