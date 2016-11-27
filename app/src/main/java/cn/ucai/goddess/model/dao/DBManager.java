package cn.ucai.goddess.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import cn.ucai.goddess.bean.DateBean;

/**
 * Created by mac-yk on 2016/11/27.
 */

public class DBManager {
    private static DBManager dbManger=new DBManager();
    private DBOpenHelper dbHelper;
    void OnInit(Context context){
        dbHelper=new DBOpenHelper(context);
    }
    public static synchronized DBManager getInstance(){
        return dbManger;
    }
    public synchronized void closeDB(){
        if(dbHelper!=null){
            dbHelper.close();
        }
    }

    public synchronized boolean saveCalendar(String date,int flag){
        SQLiteDatabase database=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(CalendarDao.DATE,date);
        values.put(CalendarDao.FLAG,flag);
        if (database.isOpen()){
            return database.replace(CalendarDao.CALENDAR_TABLE_TIME,null,values)!=-1;
        }
        return false;
    }
    public synchronized DateBean getCalendar(String date){
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        DateBean datebean=null;
        String sql="SELECT * FROM "+CalendarDao.CALENDAR_TABLE_TIME+" WHERE "+CalendarDao.DATE+" =?";
        Cursor cursor = database.rawQuery(sql, new String[]{date});
        if (cursor.moveToNext()){
            datebean=new DateBean();
            datebean.setDate(cursor.getString(cursor.getColumnIndex(CalendarDao.DATE)));
            datebean.setFlag(cursor.getInt(cursor.getColumnIndex(CalendarDao.FLAG)));
            return datebean;
        }
        return datebean;
    }

    public synchronized ArrayList<DateBean> getAll() {
        ArrayList<DateBean> dates=new ArrayList<>();
        SQLiteDatabase database=dbHelper.getReadableDatabase();
        DateBean datebean=null;
        String sql="SELECT * FROM "+CalendarDao.CALENDAR_TABLE_TIME;
        Cursor cursor = database.rawQuery(sql,null);
        while(cursor.moveToNext()){
            datebean=new DateBean();
            datebean.setDate(cursor.getString(cursor.getColumnIndex(CalendarDao.DATE)));
            datebean.setFlag(cursor.getInt(cursor.getColumnIndex(CalendarDao.FLAG)));
            dates.add(datebean);
            Log.e("main","加载一天的数据");
        }
        return dates;
    }
}
