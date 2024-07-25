package com.example.openinappassignment.repositories

import androidx.lifecycle.MutableLiveData
import com.example.openinappassignment.Model.ApiResponse
import com.example.openinappassignment.Model.RecentLinks
import com.example.openinappassignment.Model.RecyclerView1data
import com.example.openinappassignment.Services.Service
import com.example.openinappassignment.Services.apiService.apiService1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepo {

    var recentLinks=MutableLiveData<List<RecentLinks>>()

    fun getRecyclerView1data(): MutableLiveData<RecyclerView1data>{
        val service=Service.buildService(apiService1::class.java)
        val call=service.getLinks()

        var recyclerView1data=MutableLiveData<RecyclerView1data>()
        call.enqueue(object :Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {

                val data=response.body()

                if (data != null) {
                    val newRecyclerView1data = RecyclerView1data(
                        todayClicks = data.totalClicks,
                        topSource = data.topSource,
                        topLocation = data.topLocation,
                        startTime = data.startTime
                    )
                    recyclerView1data.value = newRecyclerView1data
                }

            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return recyclerView1data

    }

    fun getApiCall():MutableLiveData<List<RecentLinks>>{

        val service=Service.buildService(apiService1::class.java)
        val call=service.getLinks()

        call.enqueue(object :Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {

                val data=response.body()
                val recyclerView1Data = RecyclerView1data(
                    todayClicks = data!!.todayClicks,
                    topSource = data.topSource,
                    topLocation = data.topLocation,
                    startTime = data.startTime
                )


                recentLinks.value=data.data.recentLinks
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return recentLinks
    }
}