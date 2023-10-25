package com.example.ptbkel1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class VoteberhasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voteberhasil)

        val button = findViewById<Button>(R.id.button_home)

        button.setOnClickListener {
            Intent(this, Home::class.java).also {
                startActivity(it)
            }
        }
    }
}