package com.example.ptbkel1.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuKandidat(
    val urlimg:String?=null,
    val namaPresma:String?=null,
    val namaWaPresma:String?=null,
    val Prodi:String?=null,
    val namakandidat:String?=null,
    val visikandidat:String?=null,
    val misikandidat:String?=null,
    val misikandidat2:String?=null
):Parcelable