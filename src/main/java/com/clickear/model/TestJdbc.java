package com.clickear.model;

import com.clickear.servlet.TimestampTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/25.
 */
public class TestJdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/mydb?user=root&password=858833&serverTimezone=GMT%2b8&useSSL=false";
            Connection con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();
            String query = " select * from task_events ";
            ResultSet rs=stmt.executeQuery(query);
            List<EventsObject> m_evnetList = new ArrayList<EventsObject>();
            while(rs.next()) {
                EventsObject m_event = new EventsObject();
                m_event.setEventsid(rs.getInt(1));
                m_event.setTitle(rs.getString(2));
                m_event.setStart(new java.util.Date (rs.getTimestamp(3).getTime()));
                m_event.setEnd(new java.util.Date (rs.getTimestamp(4).getTime()));
                m_event.setDescription(rs.getString(5));
                m_event.setState(rs.getInt(6));
                m_evnetList.add(m_event);
            }
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(java.util.Date.class,new TimestampTypeAdapter());
            gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            Gson gson =gsonBuilder.create();

            System.out.println(gson.toJson(m_evnetList));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
