package cn.ucai.goddess.controller.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.dsw.calendar.component.MonthView;
import com.dsw.calendar.entity.CalendarInfo;
import com.dsw.calendar.views.GridCalendarView;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.I;
import cn.ucai.goddess.R;
import cn.ucai.goddess.model.utils.FileUtils;
import cn.ucai.goddess.model.utils.OnSetAvatarListener;

/**
 * Created by mac-yk on 2016/11/23.
 */

public class diaryFragment extends BaseFragment {
    @BindView(R.id.scale)
    public ImageView scale;
    private GridCalendarView gridCalendarView;
    OnSetAvatarListener mListener;
    Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);
        mContext=this.getActivity();
        ButterKnife.bind(this, view);
        Calendar calendar = Calendar.getInstance();
        int currYear = calendar.get(Calendar.YEAR);
        int currMonth = calendar.get(Calendar.MONTH) + 1;
        List<CalendarInfo> list = new ArrayList<CalendarInfo>();
        list.add(new CalendarInfo(currYear, currMonth, 1, null, 1));
        list.add(new CalendarInfo(currYear, currMonth, 21, null, 1));
        list.add(new CalendarInfo(currYear, currMonth, 17, null, 2));
        list.add(new CalendarInfo(currYear, currMonth, 18, null, 2));
        list.add(new CalendarInfo(currYear, currMonth, 19, null, 2));
        list.add(new CalendarInfo(currYear, currMonth, 20, null, 2));
        gridCalendarView = (GridCalendarView) view.findViewById(R.id.gridMonthView);
        gridCalendarView.setCalendarInfos(list);
        gridCalendarView.setDateClick(new MonthView.IDateClick() {

            @Override
            public void onClickOnDate(int year, int month, int day) {
                Toast.makeText(getActivity(), "点击了" + year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
            }
        });
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
        File file = FileUtils.getAvatarPath((Activity) mContext, I.AVATAR_TYPE_USER_PATH, "孟宇飞" + ".jpg");
        Bitmap bitmap= BitmapFactory.decodeFile(String.valueOf(file));
        scale.setImageBitmap(bitmap);
        Log.e("main","fragment的onResume被执行");
    }

    @OnClick(R.id.scale)
    public void onClick() {
        mListener=new OnSetAvatarListener((Activity) mContext,R.id.scale,"孟宇飞", I.AVATAR_TYPE_USER_PATH);

    }

    public OnSetAvatarListener getmListener() {
        return mListener;
    }

    public void setmListener(OnSetAvatarListener mListener) {
        this.mListener = mListener;
    }
}
