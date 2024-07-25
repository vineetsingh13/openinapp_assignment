package com.example.openinappassignment.Services.apiService

import com.example.openinappassignment.Model.ApiResponse
import com.example.openinappassignment.util.key
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface apiService1 {

    @GET("dashboardNew")
    fun getLinks(
        @Header("Authorization") authorization: String="Bearer $key",
    ):Call<ApiResponse>
}