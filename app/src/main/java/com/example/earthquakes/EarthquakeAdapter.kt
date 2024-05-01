package com.example.earthquakes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.earthquakes.models.Feature
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EarthquakeAdapter(private val earthquakeList: List<Feature>) :
    RecyclerView.Adapter<EarthquakeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewMagnitude: TextView = view.findViewById(R.id.textViewMagnitude)
        val textViewLocation: TextView = view.findViewById(R.id.textViewLocation)
        val textViewTime: TextView = view.findViewById(R.id.textViewTime)
        val layout: LinearLayout = view.findViewById(R.id.LinearLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_earthquake, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feature = earthquakeList[position]
        holder.textViewMagnitude.text = String.format("%.1f", feature.properties.mag)
        holder.textViewLocation.text = feature.properties.place
        holder.textViewTime.text = SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss", Locale.getDefault())
            .format(Date(feature.properties.time))

    }

    override fun getItemCount(): Int {
        return earthquakeList.size
    }
}