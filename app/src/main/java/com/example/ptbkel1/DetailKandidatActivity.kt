package com.example.ptbkel1

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bumptech.glide.Glide
import com.example.ptbkel1.databinding.ActivityDetailKandidatBinding
import com.example.ptbkel1.models.MenuKandidat
import com.google.firebase.messaging.FirebaseMessaging

class DetailKandidatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailKandidatBinding

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIF_ID = 0
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKandidatBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Menerima data kandidat dari intent
        val selectedKandidat = intent.getParcelableExtra<MenuKandidat>("kandidat")

        // Menampilkan data kandidat ke UI
        Glide.with(this@DetailKandidatActivity).load(selectedKandidat?.urlimg).into(binding.fotoKandidat2)
        binding.namaKandidat2.text = selectedKandidat?.namakandidat
        binding.namaPresma.text = selectedKandidat?.namaPresma
        binding.namaWaPresma.text = selectedKandidat?.namaWaPresma
        binding.Prodi.text = selectedKandidat?.Prodi
        binding.visiKandidat2.text = selectedKandidat?.visikandidat
        binding.misiKandidat3.text = selectedKandidat?.misikandidat
        binding.misiKandidat2.text = selectedKandidat?.misikandidat2
        // Anda dapat menyesuaikan kode ini sesuai dengan elemen UI dan data kandidat yang dimiliki

        createNotifChannel()

        val intent=Intent(this,MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notif = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("E-voting")
            .setContentText("Terimakasih telah voting kandidat")
            .setSmallIcon(R.drawable.voting)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()


        val notifManger = NotificationManagerCompat.from(this)


        binding.buttonVoting.setOnClickListener {
            // Pindah ke VoteberhasilActivity
            val intent = Intent(this@DetailKandidatActivity, VoteberhasilActivity::class.java)
            notifManger.notify(NOTIF_ID,notif)
            startActivity(intent)
            FirebaseMessaging.getInstance().subscribeToTopic("Vote")

            }
        }

    private fun createNotifChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.BLUE
                enableLights(true)
            }
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}