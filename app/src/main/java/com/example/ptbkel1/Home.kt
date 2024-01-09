package com.example.ptbkel1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.adapter.HomeuserAdapter
import com.example.ptbkel1.models.Homeuser
import com.google.firebase.database.*

class Home : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var votelist: ArrayList<Homeuser>
    private lateinit var adapter: HomeuserAdapter
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnLogout: Button = findViewById(R.id.button2)
        btnLogout.setOnClickListener {
            logout()
        }

        votelist = ArrayList()
        recyclerView = findViewById(R.id.recyclerView)
        adapter = HomeuserAdapter(votelist, object : HomeuserAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                // Handle item click here
                val clickedUser = votelist[position]
                Toast.makeText(this@Home, "Clicked on: ${clickedUser.namaperiode}", Toast.LENGTH_SHORT).show()

                // You can also start a new activity with additional data
                val intent = Intent(this@Home, MenuKandidatActivity::class.java)
                startActivity(intent)

            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        database = FirebaseDatabase.getInstance().getReference("Homes")
        Log.d("TESTOUTDATABASE", database.toString())
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("DATACHANGESUCCESS", "Succeed on DataChange")
                if (snapshot.exists()) {
                    votelist.clear() // Clear the list before adding new data
                    for (dataSnapShot in snapshot.children) {
                        val user = dataSnapShot.getValue(Homeuser::class.java)
                        Log.d("UserDataSnapshot", user.toString())
                        if (user != null) {
                            votelist.add(user)
                        }
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    Log.e("SNAPSHOT HOME NOT EXIST", "Kosong")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Home, error.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun logout() {
        // Lakukan operasi logout di sini, misalnya menghapus data sesi, mengarahkan kembali ke halaman login, dll.

        // Contoh: Kembali ke halaman login
        val intent = Intent(this@Home, Login::class.java)
        startActivity(intent)

        // Selesaikan aktifitas saat ini (Home)
        finish()
        }
}