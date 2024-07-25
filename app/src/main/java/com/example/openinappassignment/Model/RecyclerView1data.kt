package com.example.openinappassignment.Model

import com.google.gson.annotations.SerializedName

data class RecyclerView1data(
    @SerializedName("today_clicks") var todayClicks: Int,
    @SerializedName("top_source") var topSource: String,
    @SerializedName("top_location") var topLocation: String,
    @SerializedName("startTime") var startTime: String
)
