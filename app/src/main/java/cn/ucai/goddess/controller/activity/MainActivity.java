package cn.ucai.goddess.controller.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.goddess.I;
import cn.ucai.goddess.R;
import cn.ucai.goddess.controller.adapter.MainTabAdpter;
import cn.ucai.goddess.controller.fragment.MeFragment;
import cn.ucai.goddess.controller.fragment.diaryFragment;
import cn.ucai.goddess.controller.fragment.informationFragment;
import cn.ucai.goddess.model.utils.FileUtils;
import cn.ucai.goddess.model.utils.OnSetAvatarListener;
import cn.ucai.goddess.view.widget.DMTabHost;
import cn.ucai.goddess.view.widget.MFViewPager;

public class MainActivity extends BaseActivity implements DMTabHost.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    boolean isback;
    MainTabAdpter mAdapter;
    @BindView(R.id.tabHost)
    DMTabHost tabHost;
    int currentIndex = 0;
    @BindView(R.id.mfVp)
    MFViewPager mfVp;
    diaryFragment diaryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        isback = getIntent().getBooleanExtra("back", false);
        Log.e("main", isback + "");
        diaryFragment = new diaryFragment();
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void initView() {
        if (isback) {
            currentIndex = 1;

        }
        mAdapter = new MainTabAdpter(getSupportFragmentManager());
        mfVp.setAdapter(mAdapter);
        mfVp.setOffscreenPageLimit(3);
        mAdapter.clear();
        mAdapter.addFragment(new informationFragment(), "健康资讯");
        mAdapter.addFragment(diaryFragment, "日记");
        mAdapter.addFragment(new MeFragment(), "宝宝");
        mAdapter.notifyDataSetChanged();
        tabHost.setChecked(currentIndex);
        tabHost.setOnCheckedChangeListener(this);
        mfVp.setCurrentItem(currentIndex);
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

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        OnSetAvatarListener mListener = diaryFragment.getmListener();
        mListener.setAvatar(requestCode, data, diaryFragment.scale);
        if (requestCode == OnSetAvatarListener.REQUEST_CROP_PHOTO) {
            File file = FileUtils.getAvatarPath(this, I.AVATAR_TYPE_USER_PATH, "孟宇飞" + ".jpg");
            Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(file));
            diaryFragment.scale.setImageBitmap(bitmap);
            Log.e("main", "更新照片成功");

        }
    }
}
