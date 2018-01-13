package com.example.keduchi;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

//http://zxpic.gtimg.com/infonew/0/wechat_pics_-61477035.jpg/640
public class SecondActivity extends AppCompatActivity {

    private ImageView iv_one;
    private ImageView iv_two;
    private static final String URL = "http://zxpic.gtimg.com/infonew/0/wechat_pics_-61477035.jpg/640";
    private SimpleDraweeView fresco_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main2);

        initView();
        Glide.with(this).load(URL).into(iv_one);
        Picasso.with(this).load(URL).into(iv_two);
        Uri parse = Uri.parse(URL);
        fresco_three.setImageURI(parse);

    }

    private void initView() {
        iv_one = (ImageView) findViewById(R.id.iv_one);
        iv_two = (ImageView) findViewById(R.id.iv_two);
        fresco_three = (SimpleDraweeView) findViewById(R.id.fresco_three);
    }
}
