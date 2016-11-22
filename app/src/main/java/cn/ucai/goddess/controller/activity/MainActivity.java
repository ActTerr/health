package cn.ucai.goddess.controller.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import cn.ucai.goddess.R;
import cn.ucai.goddess.controller.fragment.AskFragment;
import cn.ucai.goddess.controller.fragment.MeFragment;

public class MainActivity extends BaseActivity {
    boolean isback;
    Fragment [] fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isback=getIntent().getBooleanExtra("back",false);
        Log.e("main",isback+"");
        initFragment();

    }

    private void initFragment() {
        if (isback==false){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl,new AskFragment()).commit();
        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl,new MeFragment()).commit();
        }

    }

    @Override
    protected void initView() {
        super.initView();
        if (!isback){

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
