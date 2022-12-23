package com.devsolutions.hygienehabitsapp.UI.App.Sesiones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devsolutions.hygienehabitsapp.Data.Model.Entities.FullReportFromSessionModel
import com.devsolutions.hygienehabitsapp.R
import com.devsolutions.hygienehabitsapp.databinding.ItemReportBySessionBinding

class ListarReportesBySessionAdapter(
    val listReportsBySession: ArrayList<FullReportFromSessionModel>
) : RecyclerView.Adapter<ListarReportesBySessionAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val binding = ItemReportBySessionBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_report_by_session, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val item = listReportsBySession[position]
            tvLevelPlayedOnSession.text = item.descriptionTitle
            tvTimePlayedOnSession.text = item.currentScoreLevel
        }
    }

    override fun getItemCount(): Int {
        return listReportsBySession.size
    }


}
