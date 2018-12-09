package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateTime {
    private int day;
    private int month;
    private int year;

    private int hour;
    private int minute;

    //Default Constructor
    public DateTime() {
    }

    //Non-default constructor for date only
    public DateTime(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Non-default constructor for parsing string
    // containing both date and time
    public DateTime(String date){
        String dateObj = date;
        String[] dateArray = dateObj.split("-");
        if (dateArray.length == 3) {
            this.day = Integer.parseInt(dateArray[0]);
            this.month = Integer.parseInt(dateArray[1]);
            this.year = Integer.parseInt(dateArray[2]);
        }
        String[] timeArray = date.split(":");
        if (timeArray.length == 2){
            this.hour = Integer.parseInt(timeArray[0]);
            this.minute = Integer.parseInt(timeArray[1]);
        }
    }

    //Non-default constructor for time only
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

    //Non-default constructor for date and time
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

    //Set the individual date elements to
    // the instance variables
    public void setDate(int day, int month, int year ){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Formats the date into a string
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

    //Gets the current system time
    public String getTime(){
        long currentDate = System.currentTimeMillis();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date resultdate = new Date(currentDate);
        return sdf1.format(resultdate);
    }

    //Gets the number of hours in days - Used for reserving a Library Item
    public Double getHoursInDays(double hours) {
        return hours / 24;
    }

    //Gets the date and time difference from the current
    // system time and the time provided - returns a HashMap
    public Map<String, Long> getDateTimeDiff(String dateTime) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String current = sdf2.format(System.currentTimeMillis());

        Date currentDateTime = null;
        Date dateTimeBorrowed = null;
        long difference = 0;
        try{
            currentDateTime = sdf2.parse(current);
            dateTimeBorrowed = sdf2.parse(dateTime);
            difference = currentDateTime.getTime() - dateTimeBorrowed.getTime();
        } catch (ParseException e){
            e.printStackTrace();
        }

        long secInMilli = 1000;
        long minInMilli = secInMilli * 60;
        long hourInMilli = minInMilli * 60;
        long dayInMilli = hourInMilli * 24;

        long elapsedDays = difference / dayInMilli;
        difference = difference % dayInMilli;

        long elapsedHours = difference / hourInMilli;
        difference = difference % hourInMilli;

        long elapsedMinutes = difference / minInMilli;

        Map<String, Long> map = new HashMap<>();
        map.put("elapsedDays", elapsedDays);
        map.put("elapsedHours", elapsedHours);
        map.put("elapsedMinutes", elapsedMinutes);
        return map;
    }



    //ToString method for both date and time
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
