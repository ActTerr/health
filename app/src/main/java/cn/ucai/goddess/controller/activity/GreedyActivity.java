package cn.ucai.goddess.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.I;
import cn.ucai.goddess.R;
import cn.ucai.goddess.model.dao.DBManager;
import cn.ucai.goddess.model.utils.MFGT;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class GreedyActivity extends BaseActivity {
    Context mContext;
    int[] layouts=new int[]{R.layout.activity_greedy,R.layout.activity_greedy2,R.layout.activity_greedy3,R.layout.activity_greedy4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random random=new Random();
        setContentView(layouts[random.nextInt(4)]);
        mContext=this;
        ButterKnife.bind(this);
        SharedPreferences sp=getSharedPreferences("date",MODE_PRIVATE);
        String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        sp.edit().putString("date", date).commit();
        DBManager.getInstance().saveCalendar(date, I.GREEDY);
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.know)
    public void onClick() {
        Intent intent=new Intent();
        intent.putExtra("back",true);
        intent.setClass(mContext,MainActivity.class);
        MFGT.startActivity(mContext,intent);
        finish();
    }
}
