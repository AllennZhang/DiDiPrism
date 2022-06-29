package com.xiaojuchefu.prism.test

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.xiaojuchefu.prism.R

/**
 *
 * Created by Jerry on 2020/8/28
 */
class FourthActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        var dialog: AlertDialog? = null
        val btnJump = findViewById<View>(R.id.btnJump)
        btnJump.setOnClickListener {
            startActivity(Intent(this@FourthActivity,FiveActivity::class.java))
//        dialog = AlertDialog.Builder(this@FourthActivity)
//                .setTitle("this is a dialog")
//                .setNegativeButton("关闭",object : DialogInterface.OnClickListener{
//                    override fun onClick(dialogI: DialogInterface?, which: Int) {
//                    }
//
//                })
//                .setPositiveButton("OK",object : DialogInterface.OnClickListener{
//                    override fun onClick(dialogI: DialogInterface?, which: Int) {
//                    }
//
//                })
//                .create()
//            dialog?.show()
//            val window = dialog?.window
//            Log.e("PrismLog", "dialog=$dialog,onResume window=$window")
        }
        var popup: PopupWindow? = null
        val button2 =  findViewById<View>(R.id.btnJump2)
        button2.setOnClickListener {
            val text = TextView(this@FourthActivity).apply {
                text = "测试PopupWindow"
                gravity = Gravity.CENTER
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)

            }
            text.setOnClickListener {
                popup?.dismiss()
            }
            popup = PopupWindow(text,-1,500)
            popup?.isOutsideTouchable = true
            popup?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#00FFFF")))
            popup?.showAsDropDown(button2)
        }
    }
}