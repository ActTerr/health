package cn.ucai.goddess.controller.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import cn.ucai.goddess.R;
import cn.ucai.goddess.controller.fragment.AskFragment;

public class MainActivity extends BaseActivity {
    boolean isback;
    Fragment [] fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        isback=getIntent().getBooleanExtra("back",false);
    }

    private void initFragment() {
        if (!isback){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl,new AskFragment()).commit();
        }

    }

    @Override
    protected void initView() {
        super.initView();
        if (!isback){

        }
    }
}
