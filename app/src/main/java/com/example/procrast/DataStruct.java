package com.example.procrast;
import java.util.*;
public class DataStruct {
    public ArrayList<Activity> activities;
    public double totalTime(){
        double val = 0;
       for(Activity act : activities){
           val += act.avgTime() + act.reps;
       }
       return val;
    }
}
