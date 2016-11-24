package cn.ucai.goddess.controller.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.goddess.R;
import cn.ucai.goddess.controller.adapter.MainTabAdpter;
import cn.ucai.goddess.controller.fragment.MeFragment;
import cn.ucai.goddess.controller.fragment.diaryFragment;
import cn.ucai.goddess.controller.fragment.informationFragment;
import cn.ucai.goddess.view.widget.DMTabHost;
import cn.ucai.goddess.view.widget.MFViewPager;

public class MainActivity extends BaseActivity implements DMTabHost.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    boolean isback;
    Fragment[] fragments;
    MainTabAdpter mAdapter;
    @BindView(R.id.tabHost)
    DMTabHost tabHost;
    int currentIndex=0;
    @BindView(R.id.mfVp)
    MFViewPager mfVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        isback = getIntent().getBooleanExtra("back", false);
        Log.e("main", isback + "");
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void initView() {
        if(isback){
            currentIndex=1;
        }
        mAdapter = new MainTabAdpter(getSupportFragmentManager());
        mfVp.setAdapter(mAdapter);
        mfVp.setOffscreenPageLimit(3);
        mAdapter.clear();
        mAdapter.addFragment(new informationFragment(), "健康资讯");
        mAdapter.addFragment(new diaryFragment(), "日记");
        mAdapter.addFragment(new MeFragment(), "宝宝");
        mAdapter.notifyDataSetChanged();
        tabHost.setChecked(currentIndex);
        tabHost.setOnCheckedChangeListener(this);
        mfVp.setOnPageChangeListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabHost.setChecked(position);
        mfVp.setCurrentItem(position);
        currentIndex = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChange(int checkedPosition, boolean byUser) {
        mfVp.setCurrentItem(checkedPosition);
        currentIndex = checkedPosition;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
