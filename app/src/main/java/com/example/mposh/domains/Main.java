package com.example.mposh.domains;

import android.os.SystemClock;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File fd=new File("E:\\Gena\\MPOSH1\\app\\src\\datas");
        String [] dirs=fd.list();
        ArrayList<City> cities=new ArrayList<>();
        for (String h: dirs){
            cities.add(new City(h));
        }
        System.out.print(cities.get(1).data);
    }
}
