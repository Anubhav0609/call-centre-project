package com.callcenter.CallCenterManagement.util;

import com.callcenter.CallCenterManagement.constant.Constants;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;

public class DateUtil {

    public static Timestamp getTimeStamp(String date){
        DateTimeFormatter formatter = DateTimeFormat.forPattern(Constants.DATETIME_FORMAT);
        DateTime dt = formatter.parseDateTime(date);
        return new Timestamp(dt.getMillis());
    }
    public static DateTime getDateTime(String date){
        DateTimeFormatter formatter = DateTimeFormat.forPattern(Constants.DATETIME_FORMAT);
        return formatter.parseDateTime(date);

    }
    public static Long getSeconds(String first, String second){
        Seconds seconds = Seconds.secondsBetween(getDateTime(first), getDateTime(second));
        return Long.parseLong(""+seconds.getSeconds());
    }
}
