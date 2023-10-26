package com.example.ptbkel1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ptbkel1.ui.theme.PTBKel1Theme

class HasilVotingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PTBKel1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HasilVoting()
                }
            }
        }
    }
}

@Composable
fun HasilVoting() {
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 76.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top ,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Hasil Voting",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Pemilihan Presiden Mahasiswa ",
            fontSize = 18.sp,
            color = Color.Black
        )
        Text(
            text = "Universitas Andalas",
            fontSize = 18.sp,
            color = Color.Black
        )

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxHeight()
                .padding(46.dp)

        ){
            TextBox()

        }
    }
}
@Composable
fun TextBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
        ) {
            Text(
                text = "PEMILIHAN PRESMA",
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                text = "UNIVERSITAS ANDALAS",
                fontSize = 10.sp,
                color = Color.Black
            )
            Text(
                text = "2023/2024",
                fontSize = 10.sp,
                color = Color.Black
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxHeight()
    ) {

        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(10.dp),


            onClick = { /*TODO*/ }) {
            Text(text = "Tambah Periode")

        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PTBKel1Theme {
        HasilVoting()
    }
}