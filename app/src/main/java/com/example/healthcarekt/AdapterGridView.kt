package com.example.healthcarekt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterGridView(var doclist : List<GridViewModel>, var context: Context) : BaseAdapter() {

var layouotInflater : LayoutInflater ?= null

    lateinit var docimage : ImageView
    lateinit var docname : TextView

    override fun getCount(): Int {
     return doclist.size
    }

    override fun getItem(position: Int): Any? {

        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView =convertView

        if (layouotInflater == null)
        {
        layouotInflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
       if (convertView == null)
       {
           convertView = layouotInflater!!.inflate(R.layout.gridview_design,null)
       }

        docname =convertView!!.findViewById(R.id.text111)
        docimage = convertView!!.findViewById(R.id.image111)


        docname.setText(doclist.get(position).Docname)
        docimage.setImageResource(doclist.get(position).Docimage)

        return convertView
    }
}