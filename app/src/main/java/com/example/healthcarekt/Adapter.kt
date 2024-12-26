package com.example.healthcarekt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private var list: ArrayList<ItemViewModel>) : RecyclerView.Adapter<Adapter.Viewholder>() {

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.healthartdesign, parent, false)
        return Viewholder(view)
    }


    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        var mypets = list[position]

        holder.imageView.setImageResource(mypets.image)
        holder.description.text = mypets.description
        holder.date.text = mypets.date
        holder.time.text = mypets.time

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class Viewholder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var imageView: ImageView = ItemView.findViewById(R.id.image)
        var description: TextView = ItemView.findViewById(R.id.txt1)
        var date: TextView = ItemView.findViewById(R.id.txt2)
        var time: TextView = ItemView.findViewById(R.id.txt3)

    }

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }
}

