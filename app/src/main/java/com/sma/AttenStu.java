package com.sma;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class AttenStu {
    String Enroll;
    String Total_Days;
    String Days_Present;
    String Month;

    public AttenStu() {
    }

    public Map<String, String> AS = new HashMap<>();

    public AttenStu(String enroll, String total_Days, String days_Present, String month) {
        Enroll = enroll;
        Total_Days = total_Days;
        Days_Present = days_Present;
        Month = month;
    }
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("enroll", Enroll);
        result.put("month", Month);
        result.put("days_present", Days_Present);
        result.put("total_days", Total_Days);
        return result;
    }

}
