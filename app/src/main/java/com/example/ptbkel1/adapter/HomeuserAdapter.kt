package com.example.ptbkel1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ptbkel1.R
import com.google.android.material.snackbar.Snackbar
import com.example.ptbkel1.models.Homeuser

class HomeuserAdapter(private val votelist: ArrayList<Homeuser>): RecyclerView.Adapter<HomeuserAdapter.voteListViewHolder>(){

    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): voteListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pemilihan, parent, false)
        return voteListViewHolder(view, myListener)
    }

    override fun onBindViewHolder(holder: HomeuserAdapter.voteListViewHolder, position: Int) {
        val currentPosition = votelist[position]
        holder.namaperiode.text = currentPosition.textnamaperiode
        holder.tahunperiode.text = currentPosition.texttahunperiode
    }

    override fun getItemCount(): Int {
        return votelist.size
    }

    class voteListViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val namaperiode : TextView = itemView.findViewById(R.id.textnamaperiode)
        val tahunperiode : TextView = itemView.findViewById(R.id.texttahunperiode)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

}