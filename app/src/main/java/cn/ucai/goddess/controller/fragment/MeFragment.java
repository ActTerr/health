package cn.ucai.goddess.controller.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.R;
import cn.ucai.goddess.bean.Goddess;
import cn.ucai.goddess.model.utils.MFGT;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class MeFragment extends BaseFragment {
    @BindView(R.id.tv_weight)
    TextView tvWeight;
    @BindView(R.id.tv_bmi)
    TextView tvBmi;
    @BindView(R.id.tv_height)
    TextView tvHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    protected void initView() {

        super.initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        Goddess g = new Goddess();
        SharedPreferences sp = getActivity().getSharedPreferences("goddess", Context.MODE_PRIVATE);
        String weight = sp.getString("weight", "57");
        g.setWeight(Double.parseDouble(weight));
        String height=sp.getString("height","167");
        g.setHeight(Double.parseDouble(height));
        tvHeight.setText("身高:" + height +"cm");
        tvWeight.setText("体重:" + weight + "kg");
        tvBmi.setText("BMI:" + getbmi(g));
    }

    private double getbmi(Goddess g) {
        return Double.parseDouble(new DecimalFormat("#.00").format(g.getWeight() / Math.pow(g.getHeight() / 100, 2)));
    }

    @OnClick(R.id.me_set)
    public void onClick() {
        MFGT.gotoSettingActivity(this.getActivity());
    }
}
