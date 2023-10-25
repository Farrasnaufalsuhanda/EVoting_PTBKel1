package com.example.ptbkel1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            Intent(this, MenuKandidatActivity::class.java).also {
                startActivity(it)
            }
        }
    }

//    fun HomeUserActivity(view: View) {
//        val Intent = Intent (this, HomeUserActivity::class.java)
//        startActivity(Intent)
//    }
}