package com.example.keduchi;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text;
    private MnScaleBar scale_bar;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            dialog.dismiss();
        }
    };
    private Dialog dialog;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        scale_bar = (MnScaleBar) findViewById(R.id.scale_bar);
        text = (TextView) findViewById(R.id.text);

        scale_bar.setOnScrollListener(new MnScaleBar.OnScrollListener() {
            @Override
            public void onScrollScale(int scale) {
                text.setText("身高：" + scale + "cm");
            }
        });


    }

    public void second(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }


    private void initView() {
        btn_three = (Button) findViewById(R.id.btn_three);

        btn_three.setOnClickListener(this);
        btn_four = (Button) findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);
        btn_five = (Button) findViewById(R.id.btn_five);
        btn_five.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_three:
                startActivity(new Intent(MainActivity.this, ThreeActivity.class));

                break;
            case R.id.btn_four:
                startActivity(new Intent(MainActivity.this, FourActivity.class));
                break;
            case R.id.btn_five:
                startActivity(new Intent(MainActivity.this,FiveActivity.class));
                break;
        }
    }
}
