package cn.ucai.goddess.controller.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.R;


/**
 * Created by mac-yk on 2016/11/23.
 */

public class informationFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_web)
    public void onClick() {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://jianfei.39.net"));
        startActivity(intent);
    }
}
