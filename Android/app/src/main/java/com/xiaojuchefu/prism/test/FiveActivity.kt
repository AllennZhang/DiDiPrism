package com.xiaojuchefu.prism.test

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.xiaojuchefu.prism.R

class FiveActivity : BaseActivity(){

    var lastScrollY : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five)
        val appBar = findViewById<AppBarLayout>(R.id.app_bar)
        val recycler: RecyclerView = findViewById(R.id.rv_cor)
        val listAdapter = CommentAdapter()
        recycler.adapter = listAdapter
        listAdapter.notifyDataSetChanged()

        findViewById<View>(R.id.iv_cor).setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(this@FiveActivity,"image",Toast.LENGTH_SHORT).show()
            }
        })

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    Log.e("FiveActivity《《《《"," SCROLL_STATE_IDLE, scrollY=$lastScrollY")
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                lastScrollY += dy
            }
        })

        findViewById<View>(R.id.fab).setOnClickListener {
            val recyclerOffset = recycler.computeVerticalScrollOffset()
            val recyclerExt = recycler.computeVerticalScrollExtent()
            val recyclerRange = recycler.computeVerticalScrollRange()
            val appbarBehavior = ((appBar.layoutParams as CoordinatorLayout.LayoutParams).behavior as AppBarLayout.Behavior)
            val appBarOffset = appbarBehavior.topAndBottomOffset
            val appBarHeight = appBar.height
            Log.e("FiveActivity《《《《 ","recycler, lastScrollY=$lastScrollY")
            Log.e("FiveActivity《《《《 ","recycler, recyclerExt=$recyclerExt, recyclerRange=$recyclerRange, recyclerOffset=$recyclerOffset")
            Log.e("FiveActivity《《《《","appBarOffset=$appBarOffset, appBarHeight=$appBarHeight")
            if (recyclerOffset > 0){
//                recycler.scrollBy(0,-lastScrollY)
                recycler.scrollToPosition(0)
            }
            if (appBarOffset < 0){
                appBar.postDelayed({
                    appbarBehavior.topAndBottomOffset = 0
                },500L)
            }
        }
    }
}