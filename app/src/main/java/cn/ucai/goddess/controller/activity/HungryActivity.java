package cn.ucai.goddess.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.R;
import cn.ucai.goddess.model.utils.MFGT;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class HungryActivity extends BaseActivity {
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hungry);
        ButterKnife.bind(this);
        mContext=this;
    }

    @OnClick(R.id.btn_continue)
    public void onClick() {
        Intent intent=new Intent();
        intent.putExtra("back",true);
        intent.setClass(mContext,MainActivity.class);
        MFGT.startActivity(mContext,intent);
    }
}
