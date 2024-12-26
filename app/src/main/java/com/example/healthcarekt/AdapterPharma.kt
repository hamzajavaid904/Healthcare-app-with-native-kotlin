package com.example.healthcarekt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterPharma (var medicine : ArrayList<ItemViewModelpharm>) : RecyclerView.Adapter<AdapterPharma.Viewholder>() {
    private var onClickListener: AdapterTD.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.product,parent,false)
        return AdapterPharma.Viewholder(view)
    }

    override fun onBindViewHolder(holder: AdapterPharma.Viewholder, position: Int) {
var med = medicine[position]
        holder.imgmed.setImageResource(med.imagemed)
        holder.medname.text = med.Medicinename
        holder.medquntity.text = med.Medicinequantity
        holder.medprice.text = med.Medicineprice

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position)
        }

    }

    override fun getItemCount(): Int {
       return medicine.size
    }
    class Viewholder(ItemView : View) : RecyclerView.ViewHolder(ItemView){

        var imgmed :ImageView = ItemView.findViewById(R.id.imgmed)
        var medname : TextView = ItemView.findViewById(R.id.namemed)
        var medquntity : TextView = ItemView.findViewById(R.id.quantitymed)
        var medprice : TextView = ItemView.findViewById(R.id.pricemed)

    }

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    interface OnClickListener : AdapterTD.OnClickListener {
        override fun onClick(position: Int)
    }

}