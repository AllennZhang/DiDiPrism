package com.xiaojuchefu.prism.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.xiaojuchefu.prism.R

class CommentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == TYPE_MATERIAL){
            MaterialHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyler_item_horizontal_list,parent,false))
        }else{
            CommentHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_comment,parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
         if (holder is CommentHolder){
             holder.bind(position)
         }else if (holder is MaterialHolder){
             holder.bind(position)
         }
    }

    override fun getItemCount(): Int {
        return 15
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0){
            TYPE_MATERIAL
        }else{
            TYPE_COMMENT
        }
    }

    inner class CommentHolder(view: View) : RecyclerView.ViewHolder(view){
        var tvComment: TextView? = null
      init {
          itemView.setOnClickListener {
              Toast.makeText(itemView.context,"查看评论",Toast.LENGTH_SHORT).show()
          }
          val avatarImg = itemView.findViewById<View>(R.id.avatar)
          avatarImg.setOnClickListener {
              Toast.makeText(itemView.context,"查看个人主页",Toast.LENGTH_SHORT).show()
          }
          tvComment = itemView.findViewById(R.id.tv_comment)
      }

      fun bind(position: Int){
          tvComment?.text = "$position  还不错，事实上老区二期科目硚口区武侯区"
      }
    }


    inner class MaterialHolder(view: View) : RecyclerView.ViewHolder(view){
       val mAdapter = MaterialListAdapter()
        init {
            val recyclerView = itemView.findViewById<RecyclerView>(R.id.rv_material)
             recyclerView.adapter = mAdapter
             mAdapter.notifyDataSetChanged()
        }

        fun bind(position: Int){
        }
    }


    companion object {
        const val TYPE_COMMENT = 0
        const val TYPE_MATERIAL = 1
    }

}