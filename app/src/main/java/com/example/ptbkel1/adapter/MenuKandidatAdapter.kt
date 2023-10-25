package com.example.ptbkel1.adapter

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.R
import com.example.ptbkel1.models.MenuKandidat

class MenuKandidatAdapter(private val kandidatlist: ArrayList<MenuKandidat>): RecyclerView.Adapter<MenuKandidatAdapter.kandidatListViewHolder>() {

    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kandidatListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_kandidat, parent, false)
        return kandidatListViewHolder(view, myListener)
    }
    override fun onBindViewHolder(holder: MenuKandidatAdapter.kandidatListViewHolder, position: Int) {
        val currentPosition = kandidatlist[position]
        holder.namakandidat.text = currentPosition.namakandidat
        holder.visikandidat.text = currentPosition.visikandidat
        holder.misikandidat.text = currentPosition.misikandidat
    }
    override fun getItemCount(): Int {
        return kandidatlist.size
    }
    class kandidatListViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val namakandidat : TextView = itemView.findViewById(R.id.namaKandidat)
        val visikandidat : TextView = itemView.findViewById(R.id.visiKandidat)
        val misikandidat : TextView = itemView.findViewById(R.id.misiKandidat)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

}