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
    @BindView(R.id.tv_bmi)
    TextView tvBmi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater,container,savedInstanceState);
        return view;
    }

    @Override
    protected void initView() {

        Log.e("main","initview被执行");
        Goddess g = new Goddess();
        g.setWeight(56.0);
        g.setHeight(167);
        tvWeight.setText("体重:" + g.getWeight() + "kg");
        Log.e("main", tvWeight.getText().toString());
        tvBmi.setText("BMI:"+getbmi(g));
        super.initView();
    }

    private double getbmi(Goddess g) {
        return Double.parseDouble(new java.text.DecimalFormat("#.00").format(g.getWeight()/Math.pow(g.getHeight()/100,2)));
    }
}
