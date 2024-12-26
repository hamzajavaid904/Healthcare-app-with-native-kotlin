package com.example.healthcarekt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.getSystemService

class GridViewAdaptertime(var Timelist : List<GridViewmodel1>,var position1: Int, var context: Context) : BaseAdapter() {



    lateinit var time : TextView
   lateinit var layoutInflater : LayoutInflater
    override fun getCount(): Int {
      return  Timelist.size
    }

    override fun getItem(position: Int): Any? {
        return null

    }

    override fun getItemId(position: Int): Long {
        return 0

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var convertView = convertView

            layoutInflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            convertView = layoutInflater!!.inflate(R.layout.time,null)




        time = convertView!!.findViewById(R.id.time)

        time.setText(timelist.get(position).Time)

        return convertView

    }


}