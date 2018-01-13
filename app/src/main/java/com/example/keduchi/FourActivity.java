package com.example.keduchi;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.keduchi.other.ListviewAdapter;
import com.example.keduchi.other.Student;

import java.util.ArrayList;

public class FourActivity extends AppCompatActivity {

    private ListView lv_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        initView();
        //建一个集合为了让在listview上显示
        ArrayList<Student> list = new ArrayList<>();
        //进程间通信得到contentResolver对象
        ContentResolver resolver = getContentResolver();
        //获取手机通讯录的uri phone.Content_uri
        Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            //人名
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            //手机号
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            list.add(new Student(name, number));
        }
        //显示在列表上
        ListviewAdapter listviewAdapter = new ListviewAdapter(this, list);
        lv_four.setAdapter(listviewAdapter);
    }

    private void initView() {
        lv_four=findViewById(R.id.lv_four);
    }
}
