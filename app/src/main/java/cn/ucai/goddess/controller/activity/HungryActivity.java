package cn.ucai.goddess.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.R;
import cn.ucai.goddess.model.utils.MFGT;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class HungryActivity extends BaseActivity {
    Context mContext;
    @BindView(R.id.ll_hungry)
    LinearLayout llHungry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_hungry);
        ButterKnife.bind(this);
        mContext = this;
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
        int drawables[]=new int[]{R.drawable.hungry,R.drawable.hungry2,R.drawable.hungry3,
                R.drawable.hungry4,R.drawable.hungry5,R.drawable.hungry6,R.drawable.hungry7};
        llHungry.setBackground(getResources().getDrawable(drawables[new Random().nextInt(7)]));
    }

    @OnClick(R.id.btn_continue)
    public void onClick() {
        Intent intent = new Intent();
        intent.putExtra("back", true);
        intent.setClass(mContext, MainActivity.class);
        MFGT.startActivity(mContext, intent);
        finish();
    }
}
