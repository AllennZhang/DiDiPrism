package com.xiaojuchefu.prism.test

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xiaojuchefu.prism.R


/**
 *
 * Created by Jerry on 2020/8/28
 */
class ThirdActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        val btnJump = findViewById<View>(R.id.btnJump)
        btnJump.setOnClickListener {
            startActivity(Intent(this@ThirdActivity, FourthActivity::class.java))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        val listAdapter = CommentAdapter()
        recyclerView.adapter = listAdapter
        listAdapter.notifyDataSetChanged()


    }

}