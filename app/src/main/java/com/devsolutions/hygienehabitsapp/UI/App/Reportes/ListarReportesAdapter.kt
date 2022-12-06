package com.devsolutions.hygienehabitsapp.UI.App.Reportes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.devsolutions.hygienehabitsapp.Data.Model.Dto.FullReportDto
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.UI.App.DetallesReportes.DetailReportFragment

class ListarReportesAdapter(val reportList: ArrayList<FullReportDto>, val layout:Int, val fragmentManager:FragmentManager) : RecyclerView.Adapter<ListarReportesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textLevel = itemView.findViewById<TextView>(R.id.descriptionsName)
        val textProgress = itemView.findViewById<TextView>(R.id.nivelProgress)
        val textMaxScore = itemView.findViewById<TextView>(R.id.descriptionsAge)
        val textPlayingTime = itemView.findViewById<TextView>(R.id.nivelPlayingTime)
        val btnDetails = itemView.findViewById<CardView>(R.id.btnDetailReport)

        fun bind(reporteModel: FullReportDto, fragmentManager:FragmentManager) {
            textLevel.text = reporteModel.descriptionTitle
            textProgress.text = reporteModel.progress.toString()
            textMaxScore.text = reporteModel.maxScore
            textPlayingTime.text = reporteModel.playingTime
            btnDetails.setOnClickListener {
                val detailsReports = DetailReportFragment(reporteModel)
                detailsReports.show(fragmentManager, "dialog_full_reports")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reportList[position], fragmentManager)
    }

    override fun getItemCount(): Int {
        return reportList.size
    }
}