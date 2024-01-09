package com.example.ptbkel1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.ptbkel1.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvToRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener{
            val email = binding.TextEmail.text.toString()
            val password = binding.TextPassword.text.toString()

            if (email.isEmpty()){
                binding.TextEmail.error = "Email harus diisi"
                binding.TextEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.TextPassword.error = "Email salah"
                binding.TextPassword.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                binding.TextPassword.error = "Password harus diisi"
                binding.TextPassword.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email,password)
        }

    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Selamat datang", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

}

