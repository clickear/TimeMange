package com.clickear.servlet;

import com.clickear.model.EventsObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.jdbc.*;
import com.mysql.cj.jdbc.PreparedStatement;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name="helloWordServlet",urlPatterns = {"/events"})
public class Events extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
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
            out.write(gson.toJson(m_evnetList));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String m_evetData = req.getParameter("eventData");
        EventsObject m_evnetObject = new EventsObject();
        if(m_evetData !=null && m_evetData !=""){
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class,new TimestampTypeAdapter());
            Gson gson =gsonBuilder.create();

            m_evnetObject = gson.fromJson(m_evetData,EventsObject.class);
            if(m_evnetObject==null)
            {
                return;
            }
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/mydb?user=root&password=858833&serverTimezone=GMT%2b8&useSSL=false";
            Connection con = DriverManager.getConnection(url);
            String query = " insert into task_events(title,start,`end`,description,state)values(?,?,?,?,?) ";
           java.sql.PreparedStatement pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,m_evnetObject.getTitle());
            pstmt.setTimestamp(2, new Timestamp(m_evnetObject.getStart().getTime()));
            pstmt.setTimestamp(3, new Timestamp(m_evnetObject.getEnd().getTime()));
            pstmt.setString(4,m_evnetObject.getDescription());
            pstmt.setInt(5,m_evnetObject.getState()==null?0:m_evnetObject.getState());

            int result = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                out.write(rs.getInt(1)+"");
                return;
            }
            if(result>0){
                out.write("true");
                return;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.write("false");

    }

}
