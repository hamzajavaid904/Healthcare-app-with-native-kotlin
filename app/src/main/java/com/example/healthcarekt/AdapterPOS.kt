package com.example.healthcarekt

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class AdapterPOS(var medicineos : ArrayList<ItemViewModelPharmsale>) : RecyclerView.Adapter<AdapterPOS.Viewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.productonsale,parent,false)
        return AdapterPOS.Viewholder(view)    }

    override fun onBindViewHolder(holder:Viewholder, position: Int) {
       var medos = medicineos[position]

        holder.imgmed.setImageResource(medos.imagemedS)
        holder.medname.text = medos.MedicinenameS
        holder.medquntity.text = medos.MedicinequantityS
        holder.medprice.text = medos.MedicinepriceS
        holder.medsaleprice.text = medos.Medicinepricesale
        holder.medsaleprice.paintFlags =holder.medsaleprice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG




    }

    override fun getItemCount(): Int {
      return  medicineos.size
    }
    class Viewholder(ItemView : View): RecyclerView.ViewHolder(ItemView){
        var imgmed : ImageView = ItemView.findViewById(R.id.imgmedsale)
        var medname : TextView = ItemView.findViewById(R.id.namemedsale)
        var medquntity : TextView = ItemView.findViewById(R.id.quantitymedsale)
        var medprice : TextView = ItemView.findViewById(R.id.pricemedsale)
        var medsaleprice : TextView=ItemView.findViewById(R.id.saleprice)



    }
}