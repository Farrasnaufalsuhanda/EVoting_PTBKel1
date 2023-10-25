package com.example.ptbkel1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailKandidatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kandidat)

        val button = findViewById<Button>(R.id.button_voting)

        button.setOnClickListener {
            Intent(this, VoteberhasilActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}