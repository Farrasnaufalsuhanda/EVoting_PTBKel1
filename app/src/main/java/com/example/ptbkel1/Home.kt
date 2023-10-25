package com.example.ptbkel1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.adapter.HomeuserAdapter
import com.example.ptbkel1.databinding.ActivityHomeBinding
import com.example.ptbkel1.models.Homeuser
import java.util.ArrayList

class Home : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var votelist: ArrayList<Homeuser>
    private lateinit var adapter: HomeuserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        votelist = ArrayList()
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))
        votelist.add(Homeuser("PEMILIHAN PRESMA UNIVERSITAS ANDALAS", "2023/2024"))


        adapter = HomeuserAdapter(votelist)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : HomeuserAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@Home, VerificationActivity::class.java)
                startActivity(intent)
            }
        })
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    fun ke_login(view: View) {
        val bundle : Bundle? = intent.extras
        val intent = Intent(this@Home, Login::class.java)
        startActivity(intent)
    }

}