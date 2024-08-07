package com.example.openinappassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.openinappassignment.Model.RecentLinks
import com.example.openinappassignment.databinding.Recyclerview2Binding
import java.text.SimpleDateFormat
import java.util.Locale


class MainActivityAdapter(val links:List<RecentLinks>): RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding=Recyclerview2Binding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val item=links[position]

        holder.itemView.apply {
            Glide.with(this).load(item.originalImage).into(holder.image)

            holder.clicks.text=item.totalClicks.toString()
            holder.sample.text=item.title.toString()
            holder.main.text=item.webLink.toString()
            val date= formatDateString(item.createdAt)
            holder.binding.linkDate.text=date
        }
    }

    override fun getItemCount(): Int {
        return links.size
    }


}

class ListViewHolder(val binding: Recyclerview2Binding,): RecyclerView.ViewHolder(binding.root) {

    val image=binding.imageIcon
    var clicks=binding.clicks
    val sample=binding.sampleLink
    val main=binding.mainLink

}

fun formatDateString(dateString: String): String {
    // Original date format
    val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
    // Desired date format
    val desiredFormat = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
    val date = originalFormat.parse(dateString)
    return desiredFormat.format(date)
}