package com.example.healthcarekt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterViewPager (var text:List<String>, var img: List<Int>) : RecyclerView.Adapter<AdapterViewPager.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){

        val text : TextView = itemview.findViewById(R.id.txt)
        val image : ImageView = itemview.findViewById(R.id.img)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewPager.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.onboard,parent,false))
    }

    override fun onBindViewHolder(holder: AdapterViewPager.Pager2ViewHolder, position: Int) {

        holder.text.text = text[position]
        holder.image.setImageResource(img[position])
    }

    override fun getItemCount(): Int {
        return text.size
    }
}