package com.sma;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class ProfileStu {
    public String SBranch, SEmail, SName, SRoll, SSect, SYear;


    public ProfileStu(String branch, String email, String name, String roll, String section, String year) {
        SBranch = branch;
        SEmail = email;
        SName = name;
        SRoll = roll;
        SSect = section;
        SYear = year;
    }

    public Map<String, String> SP = new HashMap<>();


    public ProfileStu() {
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("branch", SBranch);
        result.put("email", SEmail);
        result.put("name", SName);
        result.put("roll", SRoll);
        result.put("section", SSect);
        result.put("year", SYear);

        return result;
    }

}
