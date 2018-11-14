package com.example.administrator.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class HelloWorldActivity extends AppCompatActivity {
    private Button button = null;       //定义按键
    private boolean ledon = false;      //相当于一个flag
    private CheckBox checkBoxled1 = null;   //定义复选框
    private CheckBox checkBoxled2 = null;
    private CheckBox checkBoxled3 = null;
    private CheckBox checkBoxled4 = null;

    private Button  button_f = null;    //定义一个注销按键
    private Button  button_1 = null;     //定义显式Intent按键

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                 //调用父类onCreate方法
        setContentView(R.layout.activity_hello_world);      //给当前活动加载一个布局

        button = (Button) findViewById(R.id.button);        //从布局文件中拿到按键ID

        checkBoxled1 = (CheckBox) findViewById(R.id.LED1);  //从布局文件中拿到复选框的ID
        checkBoxled2 = (CheckBox) findViewById(R.id.LED2);
        checkBoxled3 = (CheckBox) findViewById(R.id.LED3);
        checkBoxled4 = (CheckBox) findViewById(R.id.LED4);

        button.setOnClickListener(new View.OnClickListener() {      //设置按键的监听函数
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                ledon = !ledon;
                if (ledon) {
                    button.setText("ALL ON");           //更改按键上的显示字符
                    checkBoxled1.setChecked(true);      //设置复选框选中
                    checkBoxled2.setChecked(true);
                    checkBoxled3.setChecked(true);
                    checkBoxled4.setChecked(true);
                } else {
                    button.setText("ALL OFF");          //更改按键上的显示字符
                    checkBoxled1.setChecked(false);     //设置复选框没选中
                    checkBoxled2.setChecked(false);
                    checkBoxled3.setChecked(false);
                    checkBoxled4.setChecked(false);
                }
            }
        });

        button_f = (Button) findViewById(R.id.button_f);        //获得注销按键的id
        button_f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                finish();   //注销活动
            }
        });

        /*
        *   使用显式Intent方式进行活动跳转
        *   new Intent  参数1：提供一个启动活动的上下文      参数2：指定想要启动的目标活动
        * */
        button_1 = (Button) findViewById(R.id.button_1);    //获得显式按键的id
        button_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(HelloWorldActivity.this, SecondActivity.class);
                startActivity(intent);      //启动目标活动
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*  onCreateOptionsMenu方法会显示menu菜单，结尾返回true表示创建菜单
    *   onOptionsItemSelected方法会得到xml文件中定义的菜单选项的id，然后可以做分别处理
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_world, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*      //源码
        if (id == R.id.action_settings) {
            Toast.makeText(HelloWorldActivity.this,"Sting...", Toast.LENGTH_SHORT).show();
            return true;
        }
        */
        switch (id){
            case R.id.action_settings:
                Toast.makeText(HelloWorldActivity.this,"Sting...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.add_item:
                Toast.makeText(HelloWorldActivity.this,"add...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.remove_item:
                Toast.makeText(HelloWorldActivity.this,"remove...", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked  检查复选框的单击
        switch(view.getId()) {
            case R.id.LED1:
                if (checked)    //如果是选中
                    Toast.makeText(HelloWorldActivity.this, "LED1 ON", Toast.LENGTH_SHORT).show();      //打印字符串到屏幕上
            else
                    Toast.makeText(HelloWorldActivity.this, "LED1 OFF", Toast.LENGTH_SHORT).show();
                break;
            case R.id.LED2:
                if (checked)
                    Toast.makeText(HelloWorldActivity.this, "LED2 ON", Toast.LENGTH_SHORT).show();
            else
                    Toast.makeText(HelloWorldActivity.this, "LED2 OFF", Toast.LENGTH_SHORT).show();
                break;
            case R.id.LED3:
                if (checked)
                    Toast.makeText(HelloWorldActivity.this, "LED3 ON", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(HelloWorldActivity.this, "LED3 OFF", Toast.LENGTH_SHORT).show();
                break;
            case R.id.LED4:
                if (checked)
                    Toast.makeText(HelloWorldActivity.this, "LED4 ON", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(HelloWorldActivity.this, "LED4 OFF", Toast.LENGTH_SHORT).show();
                break;
            // TODO: Veggie sandwich
        }
    }
}
