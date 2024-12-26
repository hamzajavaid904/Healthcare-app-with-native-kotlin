package com.example.healthcarekt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTD (private var list : ArrayList<ItemViewModel2>) : RecyclerView.Adapter<AdapterTD.Viewholder>() {
    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.top_doc, parent, false)
        return Viewholder(view)
    }


    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        var mypets = list[position]

        holder.image2.setImageResource(mypets.image2)
        holder.Docname.text = mypets.Docname
        holder.specaility.text = mypets.specaility
        holder.rating.text = mypets.rating
        holder.location.text = mypets.location

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class Viewholder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var image2: ImageView = ItemView.findViewById(R.id.docimage)
        var Docname: TextView = ItemView.findViewById(R.id.docname)
        var specaility: TextView = ItemView.findViewById(R.id.specaility)
        var rating: TextView = ItemView.findViewById(R.id.rating)
        var location : TextView = ItemView.findViewById(R.id.location)
    }

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }
}