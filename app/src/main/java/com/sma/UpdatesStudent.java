package com.sma;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdatesStudent  {
    public String Date, Message, Subject;

    public UpdatesStudent(String date, String subject, String message) {
        Date = date;
        Subject = subject;
        Message = message;

    }

    public Map<String, String> SU = new HashMap<>();

    public UpdatesStudent(){

    }



    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("date", Date);
        result.put("subject", Subject);
        result.put("message", Message);
        return result;
    }

}
