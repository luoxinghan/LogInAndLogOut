package com.example.luo.loginandlogout.data.util;

import android.util.Log;

import com.example.luo.loginandlogout.R;

import java.lang.reflect.Field;

public class DrawableUtil {

    /**
     * 获取图片名称获取图片的资源id的方法
     * @param imageName
     * @return
     */
    public static int getResourceByReflect(String imageName){
        Class drawable  =  R.drawable.class;
        Field field = null;
        int rID ;
        try {
            field = drawable.getField(imageName);
            rID = field.getInt(field.getName());
        } catch (Exception e) {
            rID = R.drawable.icon1;
            Log.d("ERROR", "PICTURE NOT　FOUND！");
        }
        return rID;
    }
}
