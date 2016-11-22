package cn.ucai.goddess.model.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import cn.ucai.goddess.R;
import cn.ucai.goddess.controller.activity.MainActivity;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class MFGT {
    public static void startActivity(Context context, Intent intent){
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
    public static void finish(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
    public static void stratActivity(Context context,Class<?> cls){
        Intent intent=new Intent();
        intent.setClass(context,cls);
        startActivity(context,intent);
    }
    public static void gotoMainActivity(Context context){
        stratActivity(context, MainActivity.class);
    }
}
