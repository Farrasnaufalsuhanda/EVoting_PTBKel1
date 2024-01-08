package com.example.ptbkel1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.adapter.HomeuserAdapter
import com.example.ptbkel1.models.Homeuser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class Home : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var recyclerView: RecyclerView
    private lateinit var votelist: ArrayList<Homeuser>
    private lateinit var adapter: HomeuserAdapter
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        votelist = arrayListOf()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = HomeuserAdapter(votelist)
        recyclerView.layoutManager = LinearLayoutManager(this)

        database = FirebaseDatabase.getInstance().getReference("Homes")
        Log.d("TESTOUTDATABASE", database.toString())
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("DATACHANGESUCCESS", "Succeed on DataChange")
                if (snapshot.exists()) {
                    for (dataSnapShot in snapshot.children) {
                        val user = dataSnapShot.getValue(Homeuser::class.java)
                        Log.d("UserDataSnapshot", user.toString())
                        if (!votelist.contains(user)) {
                            votelist.add(user!!)
                        }
                    }
                    recyclerView.adapter = HomeuserAdapter(votelist)
                } else {
                    Log.e("SNAPSHOT HOME NOT EXIST", "Kosong")
                }

//                try {
//                    snapshot.exists()
//                    for (dataSnapShot in snapshot.children) {
//                        val user = dataSnapShot.getValue(Homeuser::class.java)
//                        Log.d("User Data Snapshot", user.toString())
//                        if (!votelist.contains(user)) {
//                            votelist.add(user!!)
//                        }
//                    }
//                } catch (e: Exception) {
//                    Log.e("SNAPSHOT HOME NOT EXIST", e.message.toString())
//                }
            }

            override fun onCancelled(error: DatabaseError) {
              Toast.makeText(this@Home, error.toString(), Toast.LENGTH_SHORT).show()
            }
        })

        adapter = HomeuserAdapter(votelist)
        recyclerView.adapter = adapter



    }
}
