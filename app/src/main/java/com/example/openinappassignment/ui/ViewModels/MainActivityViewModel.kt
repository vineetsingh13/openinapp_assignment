package com.example.openinappassignment.ui.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openinappassignment.Model.RecentLinks
import com.example.openinappassignment.Model.RecyclerView1data
import com.example.openinappassignment.repositories.MainActivityRepo
import com.github.mikephil.charting.data.Entry

class MainActivityViewModel :ViewModel() {

    var links=MutableLiveData<List<RecentLinks>>()

    var rcdata=MutableLiveData<RecyclerView1data>()

    var graphdata=MutableLiveData<ArrayList<Entry>>()

    fun getRecentLinks():MutableLiveData<List<RecentLinks>>{

        links=MainActivityRepo.getApiCall()
        return links
    }

    fun getRecyclerView1data():MutableLiveData<RecyclerView1data>{
        rcdata=MainActivityRepo.getRecyclerView1data()
        return rcdata
    }

    fun graphdata():MutableLiveData<ArrayList<Entry>>{
        graphdata=MainActivityRepo.graphData()
        return graphdata
    }
}