package com.example.healthcarekt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AdapterDate(private var list: ArrayList<ItemViewModel3>, var pos : Int, var context : Context) : RecyclerView.Adapter<AdapterDate.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.date, parent, false)
        return Viewholder(view)
    }


    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        var mypets = list[position]
        holder.day.text = mypets.day
        holder.date.text = mypets.date

        holder.cardView.setOnClickListener {
            if (context is Doctors_Details) {
                (context as Doctors_Details).clickAdapter(position)
            }
        }

        if (pos == position){
            holder.cardView.setCardBackgroundColor(context.resources.getColor(R.color.purple_200))
        }
        else{
            holder.cardView.setCardBackgroundColor(context.resources.getColor(R.color.white))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class Viewholder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var day: TextView = ItemView.findViewById(R.id.day)
        var date: TextView = ItemView.findViewById(R.id.date)
        var cardView : CardView = ItemView.findViewById(R.id.cardview)

    }
}

