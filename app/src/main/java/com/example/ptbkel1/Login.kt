package com.example.ptbkel1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button = findViewById<Button>(R.id.button_login)

        button.setOnClickListener {
            Intent(this, Home::class.java).also {
                startActivity(it)
            }
        }
    }
}