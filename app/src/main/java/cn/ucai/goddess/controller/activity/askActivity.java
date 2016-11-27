package cn.ucai.goddess.controller.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.R;
import cn.ucai.goddess.model.utils.MFGT;

/**
 * Created by mac-yk on 2016/11/24.
 */

public class askActivity extends BaseActivity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);
        ButterKnife.bind(this);
        mContext=this;
        SharedPreferences sp=getSharedPreferences("date",MODE_PRIVATE);
        sp.edit().putString("date", new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())).commit();

    }

    @OnClick({R.id.tv_eat, R.id.tv_hungry})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_eat:
                MFGT.gotoGreedyActivity(mContext);
                finish();
                break;
            case R.id.tv_hungry:
                MFGT.gotoHungryActivity(mContext);
                finish();
                break;
        }
    }
}