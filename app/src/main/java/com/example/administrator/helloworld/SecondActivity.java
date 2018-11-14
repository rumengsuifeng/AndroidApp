package com.example.administrator.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Button button_2 = null;
    private Button button_3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button_2 = (Button)findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                finish();   //注销活动，完成返回上一页菜单的功能
            }
        });

        /*
         *   使用显式Intent方式进行活动跳转
         *   new Intent  参数1：提供一个启动活动的上下文      参数2：指定想要启动的目标活动
         * */

        button_3 = (Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(SecondActivity.this, ThreeActivity.class);
                startActivity(intent);      //启动目标活动
            }
        });
    }
}
