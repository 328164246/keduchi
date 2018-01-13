package com.example.keduchi;

import android.app.Dialog;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ThreeActivity extends AppCompatActivity {

    private Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
                dialog.dismiss();
        }
    };
    private Dialog dialog;
    private PackageManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        manager = getPackageManager();
        try {
            ArrayList<PackageInfo> list = new ArrayList<>();
            //获取本机所有apk安装信息
            List<PackageInfo> packages = manager.getInstalledPackages(0);
            for (int i = 0; i < packages.size(); i++) {
                PackageInfo pak = packages.get(i);
                //判断是手机安装的apk,如果>0是系统应用
                if((pak.applicationInfo.flags&ApplicationInfo.FLAG_SYSTEM)<=0){
                           list.add(pak);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                Toast.makeText(this, "所有本机应用包名"+list.get(i).toString(), Toast.LENGTH_SHORT).show();

            }
            //========================================================================================
            //Packageinfo 包的信息
            PackageInfo info = manager.getPackageInfo(getPackageName(), 0);
            String name = info.versionName;
            int code = info.versionCode;
            dialog = new Dialog(this);
            dialog.setTitle("版本名"+name+"====="+"版本号"+code);
            dialog.show();
            //延时5秒消失dialog
            handler.postDelayed(runnable,5000);


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


    }
}
