package com.example.openinappassignment.ui.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openinappassignment.R
import com.example.openinappassignment.adapters.MainActivityAdapter
import com.example.openinappassignment.adapters.MainActivityAdapter2
import com.example.openinappassignment.databinding.ActivityMainBinding
import com.example.openinappassignment.ui.ViewModels.MainActivityViewModel
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel: MainActivityViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.topLinksBtn.isSelected=true

        mainActivityViewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.recyclerView2.layoutManager=LinearLayoutManager(this)
        binding.recyclerView1.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        mainActivityViewModel.getRecentLinks().observe(this, Observer { response->

            response.let {
                val adapter=MainActivityAdapter(response)
                binding.recyclerView2.adapter=adapter
            }
        })

        mainActivityViewModel.getRecyclerView1data().observe(this, Observer { response ->
            response.let {
                val adapter=MainActivityAdapter2(response,this)
                binding.recyclerView1.adapter=adapter
            }
        })

        createChart()

        binding.bottomNavigationView.background=null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
    }

    private fun createChart() {
        mainActivityViewModel.graphdata().observe(this, Observer { entries ->
            entries?.let {
                val lineDataSet = LineDataSet(it, "Overall URL Chart")
                lineDataSet.color = ContextCompat.getColor(this, R.color.blue)
                lineDataSet.setDrawFilled(true)
                val drawable=ContextCompat.getDrawable(this, R.drawable.chart_gradient)
                lineDataSet.fillDrawable=drawable
                lineDataSet.fillAlpha = 50

                val lineData = LineData(lineDataSet)
                binding.chart.data = lineData


                binding.chart.axisRight.isEnabled = false
                binding.chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
                binding.chart.xAxis.setDrawGridLines(true)
                binding.chart.axisLeft.setDrawGridLines(true)
                binding.chart.xAxis.gridColor= ContextCompat.getColor(this, R.color.grey)

                binding.chart.animateX(1000)
                binding.chart.legend.isEnabled=false

                binding.chart.invalidate()
            }
        })
    }
}