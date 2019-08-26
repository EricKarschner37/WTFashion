package com.csh.erick.wtfashion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClothingRVAdapter(private val context: Context, val shirts: ArrayList<Shirt>):
    RecyclerView.Adapter<ClothingRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.clothing_frame, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shirt = shirts[position]
        holder.descText.text = shirt.name
        holder.imageView.setImageDrawable(context.getDrawable(R.drawable.shirt))
    }

    override fun getItemCount() = shirts.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val descText = itemView.findViewById<TextView>(R.id.desc_text)
        val imageView = itemView.findViewById<ImageView>(R.id.clothing_iv)
    }
}