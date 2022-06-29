package com.xiaojuchefu.prism.test;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.xiaojuchefu.prism.R;


public class SecondActivity extends BaseActivity {
  private static final String TAG = "MainActivity";
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_button);
        findViewById(R.id.btnJump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        });
        final ScrollView scrollView = findViewById(R.id.scroll);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                Log.e("SecondActivity","onScrollChange(),scrollX="+scrollX+",scrollY="+scrollY+"-------------__=========------___________---------------=============");

            }
        });
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                Log.e("SecondActivity","getScrollY(),="+scrollView.getScrollY());
            }
        });

        findViewById(R.id.h_iv_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"h-image2",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.h_iv_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"h-image4",Toast.LENGTH_SHORT).show();
            }
        });


        findViewById(R.id.image5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"image5",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
