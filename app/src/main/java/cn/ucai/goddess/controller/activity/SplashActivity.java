package cn.ucai.goddess.controller.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import cn.ucai.goddess.R;
import cn.ucai.goddess.model.receiver.AutoReceiver;
import cn.ucai.goddess.model.utils.MFGT;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class SplashActivity extends AppCompatActivity{
    private long time=2000;
    Context mContext;
    String date;
    private final static int MillisOfDay=24*60*60 * 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext=this;
        Intent intent = new Intent(this, AutoReceiver.class);
        intent.setAction("VIDEO_TIMER");
        // PendingIntent这个类用于处理即将发生的事情
        PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        // AlarmManager.ELAPSED_REALTIME_WAKEUP表示闹钟在睡眠状态下会唤醒系统并执行提示功能，该状态下闹钟使用相对时间
        // SystemClock.elapsedRealtime()表示手机开始到现在经过的时间

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 10);
        calendar.set(Calendar.MILLISECOND, 0);
        long l = calendar.getTimeInMillis() - System.currentTimeMillis();
        Log.e("main",l/1000+"");
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+l ,MillisOfDay , sender);
        //如果使用ELAPSED_REALTIME_WAKEUP类型 应该调用SystemClock.elapsedRealtime()获取相对时间在加上你设定的延迟时间
        //如果使用RTC_WAKEUP类型 应该调用System.currentTimeMillis()获取从1970.1.1号以来的时间在加上你设定的延迟时间
        getDateFlag();
    }

    private void getDateFlag() {
        SharedPreferences sp=getSharedPreferences("date",MODE_PRIVATE);
        date=sp.getString("date","");
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start=System.currentTimeMillis();

                long cost=System.currentTimeMillis()-start;
                if (cost<time){
                    try {
                        Thread.sleep(time-cost);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String curDate=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                Log.e("main",date+":"+curDate);
                if (!date.equals(curDate)){
                    MFGT.gotoAskActivity(mContext);
                    finish();
                }else {
                    MFGT.gotoMainActivity(mContext);
                }

            }
        }).start();
    }
}
