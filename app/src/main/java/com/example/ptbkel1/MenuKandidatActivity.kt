package com.example.ptbkel1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.adapter.MenuKandidatAdapter
import com.example.ptbkel1.models.MenuKandidat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList

class MenuKandidatActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var recyclerView: RecyclerView
    private lateinit var menulist: ArrayList<MenuKandidat>
    private lateinit var adapter: MenuKandidatAdapter
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_kandidat)

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
                    recyclerView.adapter =
                        MenuKandidatAdapter(menulist, this@MenuKandidatActivity)

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
                Toast.makeText(this@MenuKandidatActivity, error.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        })


    }


}