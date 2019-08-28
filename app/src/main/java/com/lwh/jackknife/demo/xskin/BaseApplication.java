package com.lwh.jackknife.demo.xskin;

import android.app.Application;
import android.widget.Toast;

import com.lwh.jackknife.xskin.SkinManager;
import com.lwh.jackknife.xskin.callback.ISkinChangedListener;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
        SkinManager.getInstance().addChangedListener(new ISkinChangedListener() {
            @Override
            public void onSkinChanged() {
                Toast.makeText(getApplicationContext(), "皮肤已改变", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
