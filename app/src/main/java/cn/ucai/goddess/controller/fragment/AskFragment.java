package cn.ucai.goddess.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.R;
import cn.ucai.goddess.model.utils.MFGT;

/**
 * Created by mac-yk on 2016/11/22.
 */

public class AskFragment extends BaseFragment {
    Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ask, container, false);
        ButterKnife.bind(this, view);
        mContext=this.getActivity();
        return view;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void setListener() {
        super.setListener();
    }

    @OnClick({R.id.tv_eat, R.id.tv_hungry})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_eat:
                MFGT.gotoGreedyActivity(mContext);
                break;
            case R.id.tv_hungry:
                MFGT.gotoHungryActivity(mContext);
                break;
        }
    }
}
