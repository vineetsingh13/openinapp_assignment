package com.example.openinappassignment.repositories

import androidx.lifecycle.MutableLiveData
import com.example.openinappassignment.Model.ApiResponse
import com.example.openinappassignment.Model.RecentLinks
import com.example.openinappassignment.Model.RecyclerView1data
import com.example.openinappassignment.Services.Service
import com.example.openinappassignment.Services.apiService.apiService1
import com.github.mikephil.charting.data.Entry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepo {

    var recentLinks=MutableLiveData<List<RecentLinks>>()

    fun graphData(): MutableLiveData<ArrayList<Entry>>{
        val entries = MutableLiveData<ArrayList<Entry>>()
        val dataEntries = arrayListOf<Entry>()
        dataEntries.add(Entry(0f, 1f,"jan"))
        dataEntries.add(Entry(1f, 12f,"jan"))
        dataEntries.add(Entry(2f, 20f,"jan"))
        dataEntries.add(Entry(3f, 30f))
        dataEntries.add(Entry(4f, 40f))
        dataEntries.add(Entry(5f, 50f))
        dataEntries.add(Entry(6f, 20f))
        dataEntries.add(Entry(7f, 30f))
        dataEntries.add(Entry(8f, 40f))


        entries.value = dataEntries

        return entries
    }

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