package cn.ucai.goddess.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cn.ucai.goddess.I;

/**
 * Created by mac-yk on 2016/11/27.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    private static DBOpenHelper instance;

    private static final String CALENDAR_TABLE_CREATE="CREATE TABLE "
        +CalendarDao.CALENDAR_TABLE_TIME + " ("
        +CalendarDao.DATE +" TEXT PRIMARY KEY, "
        +CalendarDao.FLAG +" INTEGER);";
    public DBOpenHelper(Context context) {
        super(context,getCalendarDatabaseName(), null, 1);
    }

    private static String getCalendarDatabaseName() {
        return I.Calendar.TABLE_NAME+"_demo.db";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CALENDAR_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
