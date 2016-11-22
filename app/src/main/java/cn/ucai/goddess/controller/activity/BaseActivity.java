package cn.ucai.goddess.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        setListener();
    }

    private void setListener() {

    }

    private void initData() {

    }

    private void initView() {

    }

}
