package com.example.ptbkel1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.adapter.MenuKandidatAdapter
import com.example.ptbkel1.databinding.ActivityMenuKandidatBinding
import com.example.ptbkel1.models.MenuKandidat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList

class MenuKandidatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuKandidatBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var menulist: ArrayList<MenuKandidat>
    private lateinit var adapter: MenuKandidatAdapter
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuKandidatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        menulist = arrayListOf()
        recyclerView = findViewById(R.id.recycler_view3)
        recyclerView.layoutManager = LinearLayoutManager(this)

        database = FirebaseDatabase.getInstance().getReference("Menu Kandidat")
        Log.d("TESTOUTDATABASE", database.toString())
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("DATACHANGESUCCESS", "Succeed on DataChange")
                if (snapshot.exists()) {
                    for (dataSnapShot in snapshot.children) {
                        val user = dataSnapShot.getValue(MenuKandidat::class.java)
                        Log.d("UserDataSnapshot", user.toString())
                        if (!menulist.contains(user)) {
                            menulist.add(user!!)
                        }
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    Log.e("SNAPSHOT HOME NOT EXIST", "Kosong")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MenuKandidatActivity, error.toString(), Toast.LENGTH_SHORT).show()
            }
        })

        adapter = MenuKandidatAdapter(menulist, object : MenuKandidatAdapter.OnClickListener {
            override fun onItemClick(position: Int) {
                val selectedKandidat = menulist[position]

                val intent = Intent(this@MenuKandidatActivity, DetailKandidatActivity::class.java)
                intent.putExtra("kandidat", selectedKandidat)
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
        }
}