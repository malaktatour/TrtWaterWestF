package com.example.waterwest;
import android.renderscript.Double4;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Day {
    private String date;
    private HashMap<String, Double> Times;

    public Day(String date, HashMap<String, Double> times) {
        this.date = date;
        this.Times = times;
    }

    public Day(){

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Map.Entry<String, Double>> getTimes() {

        return HashMapToArrayList(Times);
    }
    public  ArrayList<Map.Entry<String, Double>> HashMapToArrayList(HashMap<String, Double> map){

        //Getting Set of keys from map
        Set<String> keySet = map.keySet();

        //Creating an ArrayList of keys
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collections.sort(listOfKeys);//ask!!

        TreeMap<String, Double> sorted = new TreeMap<>();
        sorted.putAll(map);

        //Getting Collection of values
        Collection<Double> values = map.values();//here ya nas.

        //Creating an ArrayList of values
        ArrayList<Double> listOfValues = new ArrayList<Double>(values);

        //Getting the Set of entries
        Set<Map.Entry<String, Double>> entrySet = sorted.entrySet();


        //Creating an ArrayList Of Entry objects
        ArrayList<Map.Entry<String, Double>> listOfEntry = new ArrayList<Map.Entry<String,Double>>(entrySet);
        //Collections.reverse(listOfKeys);

        return listOfEntry;
    }

    public double GetUsedAmount ()
    {
        HashMap<String, Double> map = Times;
        Set<String> keySet = map.keySet();

        //Creating an ArrayList of keys
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
        Collections.sort(listOfKeys);//ask!!

        TreeMap<String, Double> sorted = new TreeMap<>();
        sorted.putAll(map);

        //Getting Collection of values
        Collection<Double> values = map.values();

        //Creating an ArrayList of values
        ArrayList<Double> listOfValues = new ArrayList<Double>();

        for (int i=0;i<listOfKeys.size();i++)
        {
            listOfValues.add(i,map.get(listOfKeys.get(i)));
        }


        double c=0;
        if (listOfValues.size()>1) {
            for (int i = 0; i < listOfValues.size() - 1; i++) {
                if (listOfValues.get(i) - listOfValues.get(i + 1) > 0)
                    c += listOfValues.get(i) - listOfValues.get(i + 1);

            }
        }
        return c;

    }
    public double ToDouble (String s)
    {
        double c=0,p=10,p1=Math.pow(10,s.length()-2);
        for (int i=0;i<s.length()-1;i++)
        {
            if (s.charAt(i)-'0'<0)
            {
                c+=(s.charAt(i)-'0')/p;
                p*=10;
            }
            else
            {
                c+= (s.charAt(i)-'0')*p1;
                p1/=10;
            }
        }
        return c;
        /*
        double temp2,temp1;
        temp2=ToDouble(listOfValues.get(listOfValues.size()-1));
        temp1=ToDouble(listOfValues.get(listOfValues.size()-2));
        if (temp2-temp1>0) {
            System.out.println("blah blah");
        }
        */
    }


    public void setTimes(HashMap<String, Double> times) {
        this.Times = times;
    }
}
