package com.example.openinappassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.openinappassignment.Model.RecyclerView1data
import com.example.openinappassignment.R
import com.example.openinappassignment.databinding.Recyclerview1Binding
import com.example.openinappassignment.databinding.Recyclerview2Binding

class MainActivityAdapter2(private val data: RecyclerView1data,private val context: Context) : RecyclerView.Adapter<MainActivityAdapter2.ViewHolder>() {

    class ViewHolder(val binding: Recyclerview1Binding,) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = Recyclerview1Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textToShow = when (position) {
            0 -> "${data.todayClicks}"
            1 -> data.topLocation
            2 -> data.topSource
            3 -> data.startTime
            else -> ""
        }

        val secondText = when (position) {
            0 -> "Today's Click"
            1 -> "Top Location"
            2 -> "Top Source"
            3 -> "Best Time"
            else -> ""
        }

        holder.itemView.apply {
            holder.binding.text1.text=textToShow
            holder.binding.text2.text=secondText

            when (position) {
                0 -> {
                    holder.binding.icon.backgroundTintList = ContextCompat.getColorStateList(context, R.color.pos1)
                    holder.binding.icon.icon = ContextCompat.getDrawable(context, R.drawable.clicks)

                }
                1 -> {
                    holder.binding.icon.backgroundTintList = ContextCompat.getColorStateList(context, R.color.lightblue)
                    holder.binding.icon.icon = ContextCompat.getDrawable(context, R.drawable.baseline_location_pin_24)
                    holder.binding.icon.iconTint = ContextCompat.getColorStateList(context, R.color.blue)
                }
                2 -> {
                    holder.binding.icon.backgroundTintList = ContextCompat.getColorStateList(context, R.color.pos3)
                    holder.binding.icon.icon = ContextCompat.getDrawable(context, R.drawable.insta)
                }
                3 -> {
                    holder.binding.icon.backgroundTintList = ContextCompat.getColorStateList(context, R.color.pos4)
                    holder.binding.icon.icon = ContextCompat.getDrawable(context, R.drawable.baseline_access_time_24)
                    holder.binding.icon.iconTint = ContextCompat.getColorStateList(context, R.color.orange)
                }
            }
        }
    }

    override fun getItemCount(): Int = 4
}