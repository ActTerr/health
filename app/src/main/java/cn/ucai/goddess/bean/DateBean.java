package cn.ucai.goddess.bean;

import java.io.Serializable;

/**
 * Created by mac-yk on 2016/11/27.
 */

public class DateBean implements Serializable{
    private String date;
    private int flag;

    public DateBean() {
    }

    public DateBean(String date, int flag) {
        this.date = date;
        this.flag = flag;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "date{" +
                "date='" + date + '\'' +
                ", flag=" + flag +
                '}';
    }
}
