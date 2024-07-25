package com.example.openinappassignment.Model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("status") val status: Boolean,
    @SerializedName("statusCode") val statusCode: Int,
    @SerializedName("message") val message: String,
    @SerializedName("support_whatsapp_number") val supportWhatsappNumber: String,
    @SerializedName("extra_income") val extraIncome: Double,
    @SerializedName("total_links") val totalLinks: Int,
    @SerializedName("total_clicks") val totalClicks: Int,
    @SerializedName("today_clicks") val todayClicks: Int,
    @SerializedName("top_source") val topSource: String,
    @SerializedName("top_location") val topLocation: String,
    @SerializedName("startTime") val startTime: String,
    @SerializedName("links_created_today") val linksCreatedToday: Int,
    @SerializedName("applied_campaign") val appliedCampaign: Int,
    @SerializedName("data") val data: Data
)
data class Data(
    @SerializedName("recent_links") val recentLinks: List<RecentLinks>
)