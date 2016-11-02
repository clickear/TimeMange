package com.clickear.model;

import com.clickear.servlet.TimestampTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/24.
 */
public class TestDateTime {

    public static void main(String[] args) {
        DateTime dateTime = new DateTime("2004-12-13T");
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'");
        System.out.println(dateTime.toString());
        dateTime = fmt.parseDateTime("2004-12-17T");
        System.out.println(dateTime.toString());


        String m_evetData = "{\"eventsid\":1,\"title\":\"测试用例\",\"start\":\"2016-10-27T22:50:33\",\"end\":\"2016-10-30T00:00:00\",\"description\":\"this is a rescriptions\",\"source\":{\"url\":\"/events\",\"cache\":true,\"className\":[],\"_fetchId\":1,\"_status\":\"resolved\"},\"_id\":\"_fc1\",\"className\":[],\"allDay\":false,\"_allDay\":false,\"_start\":\"2016-10-27T22:50:33\",\"_end\":\"2016-10-30T00:00:00\"}";
        if(m_evetData !=null && m_evetData !=""){
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class,new TimestampTypeAdapter());
            Gson gson =gsonBuilder.create();
            System.out.println(gson.fromJson(m_evetData,EventsObject.class));
        }

    }
}
