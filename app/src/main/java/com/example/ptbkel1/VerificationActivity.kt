package com.example.ptbkel1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class VerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        val button = findViewById<Button>(R.id.button_verify)

        button.setOnClickListener {
            Intent(this, MenuKandidatActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}