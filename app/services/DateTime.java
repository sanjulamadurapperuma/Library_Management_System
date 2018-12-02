package services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    private int day;
    private int month;
    private int year;

    private int hour;
    private int minute;

    public DateTime() {
    }

    public DateTime(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DateTime(String date){
        String dateObj = date;
        String[] dateArray = dateObj.split("/");
        if (dateArray.length == 3) {
            this.day = Integer.parseInt(dateArray[0]);
            this.month = Integer.parseInt(dateArray[1]);
            this.year = Integer.parseInt(dateArray[2]);
        }
    }

    public DateTime(int hour, int minute){
        if ( hour >= 1 && hour <= 23){
            this.hour = hour;
        } else{
            this.hour = 0;
        }
        if ( minute >= 0 && minute <= 59){
            this.minute = minute;
        }
        else {
            this.minute = 0;
        }
    }

    public DateTime(int day, int month, int year,
                    int hour, int minute){
        this.day = day;
        this.month = month;
        this.year = year;

        if ( hour >= 1 && hour <= 23){
            this.hour = hour;
        } else{
            this.hour = 0;
        }
        if ( minute >= 0 && minute <= 59){
            this.minute = minute;
        }
        else {
            this.minute = 0;
        }
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setDate(int day, int month, int year ){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDate(){
        String formattedDay;
        if (day < 10){
            formattedDay = String.format("%02d", day);
        } else{
            formattedDay = Integer.toString(getDay());
        }

        String formattedMonth;
        if (month < 10) {
            formattedMonth = String.format("%02d", month);
        } else{
            formattedMonth = Integer.toString(getMonth());
        }
        return formattedDay + "/" + formattedMonth + "/" + getYear();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getTime(){
        long currentDate = System.currentTimeMillis();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date resultdate = new Date(currentDate);
        return sdf1.format(resultdate);
    }

    @Override
    public String toString() {
        String time = "";
        if ( hour < 10 && minute < 10)
            time = "0" + hour + "0" + minute;
        else if ( hour < 10 && minute > 10)
            time = "0" + hour + minute;
        else if ( hour > 10 && minute < 10)
            time = hour + "0" + minute;
        else if ( hour > 10 && minute > 10)
            time = hour +""+ minute;
        else if ( hour == 0)
            time = "0" + hour + minute;
        else if ( minute == 0)
            time = hour + "0" + minute;
        return getDate() + time;
    }
}
