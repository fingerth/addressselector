package com.fingerth.jdaddressselector.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AddressStaticUtils {

    private static int sysWidth = 0;
    private static int sysHeight = 0;

    /**
     * 获取手机的分比率，高和宽
     */
    public static void getScreen(Activity activity) {
        if (AddressStaticUtils.sysWidth <= 0 || AddressStaticUtils.sysHeight <= 0) {
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            AddressStaticUtils.sysWidth = dm.widthPixels;
            AddressStaticUtils.sysHeight = dm.heightPixels;
        }
    }

    public static int getSysWidth(Activity activity) {
        if (AddressStaticUtils.sysWidth <= 0) {
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            AddressStaticUtils.sysWidth = dm.widthPixels;
        }
        return AddressStaticUtils.sysWidth;
    }

    public static int getSysHeight(Activity activity) {
        if (AddressStaticUtils.sysHeight <= 0) {
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            AddressStaticUtils.sysHeight = dm.heightPixels;
        }
        return AddressStaticUtils.sysHeight;
    }


    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }



}
