package com.clickear.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */
public class MyGsonLib {

    private  static  Gson gson = new Gson();
    public static <T> List<T> asList(String json, String path, Class<T> clazz) {
        Gson gson = new Gson();
        String[] paths = path.split("\\.");
        JsonObject o = gson.fromJson(json, JsonObject.class);
        for (int i = 0; i < paths.length - 1; i++) {
            o = o.getAsJsonObject(paths[i]);
        }
        JsonArray jsonArray = o.getAsJsonArray(paths[paths.length - 1]);
        Class<T[]> clazzArray = (Class<T[]>) ((T[]) Array.newInstance(clazz, 0)).getClass();
        T[] objectArray = gson.fromJson(jsonArray, clazzArray);
        return Arrays.asList(objectArray);
    }

    public static <T> T asObject(String json, String path, Class<T> clazz) {
        JsonElement jsonElement = asObject(json,path);
        if(jsonElement !=null){
            return gson.fromJson(jsonElement,clazz);
        }
        return  null;
    }

    public  static JsonElement asObject(String json, String path){
        String[] paths = path.split("\\.");
        JsonObject obj = gson.fromJson(json, JsonObject.class);
        for (String element : paths) {
            String keyStr = element;
            int indexNum = 0;
            String[] result = getArrayStr(element);
            if(result.length ==2 && result[1] !=null){
                keyStr = result[0];
                indexNum = Integer.parseInt(result[1]);
            }

            if (obj != null) {
                JsonElement ele = obj.get(keyStr);
                if (!ele.isJsonObject()){
                    if(ele.isJsonArray()){
                        JsonArray jsonArray = ele.getAsJsonArray();
                        if(jsonArray.size()>indexNum){
                            ele = jsonArray.get(indexNum);
                            obj = ele.getAsJsonObject();
                        }
                    }else{
                        return ele;
                    }
                }
                else
                    obj = ele.getAsJsonObject();
            } else {
                return null;
            }
        }
        return obj;
    }

    public static String[] getArrayStr(String element){
        String[] result = new String[2];
        int firstIndex = element.indexOf('[');
        int endIndex = element.indexOf(']');
        if(firstIndex>0 && endIndex>0){
            result[0] = element.substring(0,firstIndex);
            result[1] = element.substring(firstIndex +1,endIndex);
        }else{
            result[0] = element;
            result[1] = null;
        }
        return  result;
    }

}
