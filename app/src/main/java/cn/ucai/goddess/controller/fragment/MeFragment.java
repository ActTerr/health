package cn.ucai.goddess.controller.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.goddess.R;
import cn.ucai.goddess.bean.Goddess;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class MeFragment extends BaseFragment {
    @BindView(R.id.tv_weight)
    TextView tvWeight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initView() {
        super.initView();
        Goddess g=new Goddess();
        g.setWeight(56.0);
        tvWeight.setText("体重:"+g.getWeight()+"kg");
        Log.e("main",tvWeight.getText().toString());
    }
}