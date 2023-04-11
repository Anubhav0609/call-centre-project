package com.callcenter.CallCenterManagement.util;

public class UtilService {


    public static String getDayName(Integer day){
        String dayName = "";
        switch (day){
            case 0:
                dayName ="Sunday";
                break;
            case 1:
                dayName ="Monday";
                break;
            case 2:
                dayName ="TuesDay";
                break;

                case 3:
                dayName ="Wednesday";
                break;
                case 4:
                dayName ="Thursday";
                break;
                case 5:
                dayName ="Friday";
                break;

            case 6:
                dayName ="Saturday";
                break;



        }
        return dayName;
    }
}
