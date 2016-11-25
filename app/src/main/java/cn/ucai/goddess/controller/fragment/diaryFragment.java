package cn.ucai.goddess.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dsw.calendar.component.MonthView;
import com.dsw.calendar.entity.CalendarInfo;
import com.dsw.calendar.views.GridCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cn.ucai.goddess.R;

/**
 * Created by mac-yk on 2016/11/23.
 */

public class diaryFragment extends BaseFragment {
    private GridCalendarView gridCalendarView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary, container, false);
        Calendar calendar = Calendar.getInstance();
        int currYear = calendar.get(Calendar.YEAR);
        int currMonth = calendar.get(Calendar.MONTH)+ 1;
        List<CalendarInfo> list = new ArrayList<CalendarInfo>();
        list.add(new CalendarInfo(currYear,currMonth,4,"￥1200"));
        list.add(new CalendarInfo(currYear,currMonth,6,"￥1200"));
        list.add(new CalendarInfo(currYear,currMonth,12,"￥1200"));
        list.add(new CalendarInfo(currYear,currMonth,16,"￥1200"));
        list.add(new CalendarInfo(currYear,currMonth,28,"￥1200"));
        list.add(new CalendarInfo(currYear,currMonth,1,"￥1200",1));
        list.add(new CalendarInfo(currYear,currMonth,11,"￥1200",1));
        list.add(new CalendarInfo(currYear,currMonth,19,"￥1200",2));
        list.add(new CalendarInfo(currYear,currMonth,21,"￥1200",1));
        gridCalendarView = (GridCalendarView) view.findViewById(R.id.gridMonthView);
        gridCalendarView.setCalendarInfos(list);
        gridCalendarView.setDateClick(new MonthView.IDateClick(){

            @Override
            public void onClickOnDate(int year, int month, int day) {
                Toast.makeText(getActivity(),"点击了" +  year + "-" + month + "-" + day,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
