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
//    private static final String FULICENTER_USER_TABLE_CREATE = "CREATE TABLE "
//            + UserDao.USER_TABLE_NAME + " ("
//            + UserDao.USER_COLUMN_NAME + " TEXT PRIMARY KEY, "
//            + UserDao.USER_COLUMN_NICK + " TEXT, "
//            + UserDao.USER_COLUMN_AVATAR_ID + " INTEGER, "
//            + UserDao.USER_COLUMN_AVATAR_TYPE + " INTEGER, "
//            + UserDao.USER_COLUMN_AVATAR_PATH + " TEXT, "
//            + UserDao.USER_COLUMN_AVATAR_SUFFIX + " TEXT, "
//            + UserDao.USER_COLUMN_AVATAR_LASTUPDATE_TIME + " TEXT);";
    private static final String CALENDAR_TABLE_CREATE="CREATE TABLE";
    public DBOpenHelper(Context context) {
        super(context,getCalendarDatabaseName(), null, 1);
    }

    private static String getCalendarDatabaseName() {
        return I.Calendar.TABLE_NAME+"_demo.db";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
