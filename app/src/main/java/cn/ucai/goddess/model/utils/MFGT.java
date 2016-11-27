package cn.ucai.goddess.model.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import cn.ucai.goddess.R;
import cn.ucai.goddess.controller.activity.GreedyActivity;
import cn.ucai.goddess.controller.activity.HungryActivity;
import cn.ucai.goddess.controller.activity.MainActivity;
import cn.ucai.goddess.controller.activity.SettingActivity;
import cn.ucai.goddess.controller.activity.askActivity;

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
    public static void startActivity(Context context,Class<?> cls){
        Intent intent=new Intent();
        intent.setClass(context,cls);
        startActivity(context,intent);
    }
    public static void gotoMainActivity(Context context){
        startActivity(context, MainActivity.class);
    }
    public static void backMainActivity(Context context){
        startActivity(context,MainActivity.class);
    }
    public static void gotoHungryActivity(Context context){
        startActivity(context, HungryActivity.class);
    }
    public static void gotoGreedyActivity(Context context){
        startActivity(context, GreedyActivity.class);
    }
    public static void gotoAskActivity(Context context){
        startActivity(context,askActivity.class);
    }
    public static void gotoSettingActivity(Context context){
        startActivity(context, SettingActivity.class);
    }

}
