package com.lwh.jackknife.demo.xskin;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.lwh.jackknife.xskin.SkinManager;
import com.lwh.jackknife.xskin.base.BaseSkinActivity;
import com.lwh.jackknife.xskin.callback.ISkinChangingCallback;

import java.io.File;

/**
 * 必须继承BaseSkinActivity。XSkin换肤框架支持本地xml和皮肤包的换肤。
 */
public class MainActivity extends BaseSkinActivity {

    private Button btn_change_bg_color;
    private Button btn_change_by_plugin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SkinManager.getInstance().changeSkin("blue");   //先选一套默认的皮肤，如果想切回资源文件定义的，直接设置空字符串
        btn_change_bg_color = findViewById(R.id.btn_change_bg_color);
        btn_change_bg_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkinManager.getInstance().changeSkin("red");
            }
        });
        btn_change_by_plugin = findViewById(R.id.btn_change_by_plugin);
        btn_change_by_plugin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //6.0+的动态权限申请自行处理
                String skinPluginPath = Environment.getExternalStorageDirectory().getAbsolutePath()
                        + File.separator + "xskin_theme_plugin.apk";    //要把这个皮肤包放在手机系统根目录下
                String pkgName = "com.lwh.jackknife.demo.xskin_theme_plugin";   //皮肤包的包名
                SkinManager.getInstance().changeSkin(skinPluginPath, pkgName, "red",
                        new ISkinChangingCallback.DefaultSkinChangingCallback());    //再改变皮肤
            }
        });
    }
}
