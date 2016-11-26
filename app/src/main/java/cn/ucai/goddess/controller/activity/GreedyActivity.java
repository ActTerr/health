package cn.ucai.goddess.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.R;
import cn.ucai.goddess.model.utils.MFGT;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class GreedyActivity extends BaseActivity {
    Context mContext;
    int[] layouts=new int[]{R.layout.activity_greedy,R.layout.activity_greedy2,R.layout.activity_greedy3,R.layout.activity_greedy4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random random=new Random();
        setContentView(layouts[random.nextInt(4)]);
        ButterKnife.bind(this);
        mContext=this;
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
