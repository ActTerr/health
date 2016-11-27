package cn.ucai.goddess.model.dao;

import android.content.Context;

import java.util.ArrayList;

import cn.ucai.goddess.bean.DateBean;

/**
 * Created by mac-yk on 2016/11/27.
 */

public class CalendarDao {
    public static final String CALENDAR_TABLE_TIME="calendar";
    public static final String DATE="date";
    public static final String FLAG="flag";
    public boolean saveCalendar(String date,int flag){
        return DBManager.getInstance().saveCalendar(date,flag);
    }
    public CalendarDao(Context context){
        DBManager.getInstance().OnInit(context);
        DBOpenHelper.onInit(context);
    }
    public DateBean getCalendar(String date){
        return  DBManager.getInstance().getCalendar(date);
    }
    public ArrayList<DateBean> getAll(){
        return  DBManager.getInstance().getAll();
    }
}
