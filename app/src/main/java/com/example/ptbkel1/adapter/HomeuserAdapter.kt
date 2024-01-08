package com.example.ptbkel1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.R
import com.example.ptbkel1.models.Homeuser

class HomeuserAdapter(votelist: ArrayList<Homeuser>) : RecyclerView.Adapter<HomeuserAdapter.voteListViewHolder>(){

    private val _votelist = votelist

    class voteListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val namaperiode : TextView = itemView.findViewById(R.id.textnamaperiode)
        val tahunperiode : TextView = itemView.findViewById(R.id.texttahunperiode)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): voteListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pemilihan, parent, false)
        return voteListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeuserAdapter.voteListViewHolder, position: Int) {
        holder.namaperiode.text = _votelist[position].namaperiode
        holder.tahunperiode.text = _votelist[position].tahunperiode
    }

    override fun getItemCount(): Int {
        return _votelist.size
    }

}