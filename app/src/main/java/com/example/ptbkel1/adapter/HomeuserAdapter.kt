package com.example.ptbkel1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.R
import com.example.ptbkel1.models.Homeuser

class HomeuserAdapter(private val votelist: ArrayList<Homeuser>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<HomeuserAdapter.VoteListViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class VoteListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaperiode: TextView = itemView.findViewById(R.id.textnamaperiode)
        val tahunperiode: TextView = itemView.findViewById(R.id.texttahunperiode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoteListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pemilihan, parent, false)
        return VoteListViewHolder(view)
    }

    override fun onBindViewHolder(holder: VoteListViewHolder, position: Int) {
        val currentUser = votelist[position]
        holder.namaperiode.text = currentUser.namaperiode
        holder.tahunperiode.text = currentUser.tahunperiode

        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return votelist.size
        }
}