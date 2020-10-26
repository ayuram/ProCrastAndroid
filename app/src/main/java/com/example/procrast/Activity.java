package com.example.procrast;
import android.graphics.drawable.ColorDrawable;

import java.util.*;
public class Activity {
    public String name;
    public ArrayList<Double> times;
    public int reps;
    public UUID uuid;

    public Activity(String name){
        this.name = name;
        times = new ArrayList<Double>();
        uuid = UUID.randomUUID();
        reps = 1;
    }
    public double avgTime(){
        double val = 0;
        for(int i = 0; i < times.size(); i++){
            val += times.get(i);
        }
        return val/times.size();
    }
    public double medianTime(){
        ArrayList<Double> val = new ArrayList<Double>();
        for(int i = 0; i < times.size(); i++){
            val.add(times.get(i));
        }
        Collections.sort(val);
        return val.get(val.size()/2);
    }

    public boolean equals(Activity act){
        return uuid == act.uuid;
    }
}