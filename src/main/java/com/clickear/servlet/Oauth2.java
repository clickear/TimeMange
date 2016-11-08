package com.clickear.servlet;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@WebServlet(name="oauth",urlPatterns = {"/callback"})
public class Oauth2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        https://openapi.baidu.com/oauth/2.0/authorize?
//        response_type=token&
//                client_id=Va5yQRHlA4Fq4eR3LT0vuXV4&
//                redirect_uri=http%3A%2F%2Fwww.example.com%2Foauth_redirect&
//                scope=email&
//                display=popup&
//                state=xxx
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        final String clientId = "c774a0b7d7c450193689";
        final String clientSecret = "0a8cf7435cf2b5a9bc857c9643f608efe967ea01";
        String code = request.getParameter("code");
        String callback = "http://localhost:8080/callback";

       String url = String.format("https://github.com/login/oauth/access_token?grant_type=%s&client_id=%s&client_secret=%s&code=%s&redirect_uri=%s", "authorization_code", clientId, clientSecret, code, callback);


        String result = "";
        String urlNameString = "http://openapi.baidu.com/oauth/2.0/authorize?response_type=token&client_id=CuOLkaVfoz1zGsqFKDgfvI0h&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Findex&scope=netdisk&display=popup";
        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        URLConnection connection = realUrl.openConnection();
        // 设置通用的请求属性
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // 建立实际的连接
        connection.connect();
        // 获取所有响应头字段
        Map<String, List<String>> map = connection.getHeaderFields();
        // 遍历所有的响应头字段
        for (String key : map.keySet()) {
            System.out.println(key + "--->" + map.get(key));
        }
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream(),"utf-8"));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }

        String[] m_parm = result.split("&");
        String accesToken = "";
        for(String m_key :m_parm)
        {
            if(m_key.indexOf('=')>0)
            {
                String m_k = m_key.substring(0,m_key.indexOf('='));
                String m_v = m_key.substring(m_key.indexOf('=')+1);
                if(m_k.equals("access_token"))
                {
                    accesToken = m_v;
                }
            }
        }

         result = "";
         line="";
        urlNameString = "https://api.github.com/user?access_token=6dd17d3f6257bdeb8a289f8081021b04ab428749";
        realUrl = new URL(urlNameString);
        // 打开和URL之间的连接
        connection = realUrl.openConnection();
        // 设置通用的请求属性
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // 建立实际的连接
        connection.connect();
        // 获取所有响应头字段
        map = connection.getHeaderFields();
        // 遍历所有的响应头字段
        for (String key : map.keySet()) {
            System.out.println(key + "--->" + map.get(key));
        }
        // 定义 BufferedReader输入流来读取URL的响应
        in = new BufferedReader(new InputStreamReader(
                connection.getInputStream(),"utf-8"));
        while ((line = in.readLine()) != null) {
            result += line;
        }
        out.write(result);

    }



}
