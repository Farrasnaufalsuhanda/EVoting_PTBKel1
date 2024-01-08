package com.example.ptbkel1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ptbkel1.MenuKandidatActivity
import com.example.ptbkel1.R
import com.example.ptbkel1.databinding.ActivityMenuKandidatBinding
import com.example.ptbkel1.models.MenuKandidat

class MenuKandidatAdapter(
    private val menulist: ArrayList<MenuKandidat>,
    var c:Context
):
    RecyclerView.Adapter<MenuKandidatAdapter.menuListViewHolder>() {

    inner class menuListViewHolder(v: ActivityMenuKandidatBinding) : RecyclerView.ViewHolder(v.root)

//    class menuListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val namakandidat : TextView = itemView.findViewById(R.id.namaKandidat)
//        val visikandidat : TextView = itemView.findViewById(R.id.visiKandidat)
//        val misikandidat : TextView = itemView.findViewById(R.id.misiKandidat)
//        val misikandidat2 : TextView = itemView.findViewById(R.id.misiKandidat4)
//        val image : ImageView = itemView.findViewById(R.id.fotoKandidat)
//
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuListViewHolder {
//        val view = LayoutInflater.from(parent.context)
//        return menuListViewHolder(v)
    }
//    override fun onBindViewHolder(holder: MenuKandidatAdapter.menuListViewHolder, position: Int) {
//        val currentPosition = menulist[position]
//        Glide.with(context).load(currentPosition.urlimg).into(holder.image)
//        holder.namakandidat.text = currentPosition.namakandidat
//        holder.visikandidat.text = currentPosition.visikandidat
//        holder.misikandidat.text = currentPosition.misikandidat
//        holder.misikandidat2.text = currentPosition.misikandidat2
//
//    }
    override fun getItemCount(): Int {
        return menulist.size
    }

}