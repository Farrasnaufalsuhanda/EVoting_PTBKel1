package com.example.ptbkel1

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.ptbkel1.databinding.ActivityVerificationBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth

class VerificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerificationBinding
    private var storeVerificationId : String?=""
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        storeVerificationId = intent.getStringExtra("storeVerificationId")

        binding.buttonVerify.setOnClickListener({
            verifyPhoneNumberWithCode(storeVerificationId,binding.textverify.text.toString())
        })
    }

    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {
        // [START verify_with_code]
        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        // [END verify_with_code]
        signInWithPhoneAuthCredential(credential)
    }

    // [START sign_in_with_phone]
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("success", "signInWithCredential:success")

                    val user = task.result?.user
                    val intent = Intent(this@VerificationActivity,MenuKandidatActivity::class.java)
                    startActivity(intent)
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w("failed", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }
}