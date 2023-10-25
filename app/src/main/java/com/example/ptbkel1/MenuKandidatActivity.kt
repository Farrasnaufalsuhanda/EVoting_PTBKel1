package com.example.ptbkel1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.adapter.MenuKandidatAdapter
import com.example.ptbkel1.databinding.ActivityMenuKandidatBinding
import com.example.ptbkel1.models.MenuKandidat
import java.util.ArrayList

class MenuKandidatActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMenuKandidatBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var kandidatlist: ArrayList<MenuKandidat>
    private lateinit var adapter: MenuKandidatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuKandidatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar3)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        recyclerView = findViewById(R.id.recycler_view3)
        recyclerView.layoutManager = LinearLayoutManager(this)

        kandidatlist = ArrayList()
        kandidatlist.add(MenuKandidat("PRESMA UNIVERSITAS ANDALAS 1", "Visi Kandidat", "Misi Kandidat"))
        kandidatlist.add(MenuKandidat("PRESMA UNIVERSITAS ANDALAS 2", "Visi Kandidat", "Misi Kandidat"))
        kandidatlist.add(MenuKandidat("PRESMA UNIVERSITAS ANDALAS 3", "Visi Kandidat", "Misi Kandidat"))
        kandidatlist.add(MenuKandidat("PRESMA UNIVERSITAS ANDALAS 4", "Visi Kandidat", "Misi Kandidat"))

        adapter = MenuKandidatAdapter(kandidatlist)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MenuKandidatAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
            }
        })
    }
    fun ke_detail(view: View) {
        val bundle : Bundle? = intent.extras
//        val nama = bundle!!.getString("nama")
//        val nim = bundle!!.getString("nim")
        val intent = Intent(this@MenuKandidatActivity, DetailKandidatActivity::class.java)
//        intent.putExtra("nama", nama)
//        intent.putExtra("nim", nim)
        startActivity(intent)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}