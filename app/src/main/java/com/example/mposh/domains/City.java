package com.example.mposh.domains;

import com.google.gson.Gson;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class City {
    static JSONParser parser = new JSONParser();
    public ArrayList data;
    public String name;
    public City(String path){
        JSONObject object=new JSONObject();
        try{
        object =  (JSONObject) parser.parse(new FileReader("E:\\Gena\\MPOSH1\\app\\src\\datas" +path));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        Gson gson=new Gson();
        ArrayList list=gson.fromJson(object.toJSONString(),ArrayList.class);
        this.data=list;
        this.name=path.replace(".json","");
    }
}
