package com.example.openinappassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openinappassignment.adapters.MainActivityAdapter
import com.example.openinappassignment.databinding.ActivityMainBinding
import com.example.openinappassignment.ui.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel: MainActivityViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainActivityViewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.recyclerView2.layoutManager=LinearLayoutManager(this)

        mainActivityViewModel.getRecentLinks()!!.observe(this, Observer { response->

            response.let {
                val adapter=MainActivityAdapter(response)
                binding.recyclerView2.adapter=adapter
            }
        })
    }
}