package com.example.openinappassignment.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openinappassignment.Model.RecentLinks
import com.example.openinappassignment.Model.RecyclerView1data
import com.example.openinappassignment.repositories.MainActivityRepo

class MainActivityViewModel :ViewModel() {

    var links=MutableLiveData<List<RecentLinks>>()

    var rcdata=MutableLiveData<RecyclerView1data>()

    fun getRecentLinks():MutableLiveData<List<RecentLinks>>{

        links=MainActivityRepo.getApiCall()
        return links
    }

    fun getRecyclerView1data():MutableLiveData<RecyclerView1data>{
        rcdata=MainActivityRepo.getRecyclerView1data()
        return rcdata
    }
}