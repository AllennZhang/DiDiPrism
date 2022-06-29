package com.xiaojuchefu.prism.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.xiaojuchefu.prism.R

class MaterialListAdapter: RecyclerView.Adapter<MaterialListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_image,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
       return 10
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var tvName: TextView? = null
        init {
            tvName = itemView.findViewById(R.id.tv_name)
            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"查看素材",Toast.LENGTH_SHORT).show()
            }
        }
        fun bind(position: Int){
            tvName?.text = "material $position"
        }
    }

}