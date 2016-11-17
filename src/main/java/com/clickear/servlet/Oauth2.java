package com.clickear.servlet;

import com.clickear.pcs.OAuthBuilder;
import com.clickear.pcs.OAuthService;
import com.clickear.utils.MyGsonLib;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
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
        String code = request.getParameter("code");
        OAuthService service = new OAuthBuilder()
                .accessTokenEndpoint("https://github.com/login/oauth/access_token")
                .apiKey("c774a0b7d7c450193689")
                .apiSecret("0a8cf7435cf2b5a9bc857c9643f608efe967ea01")
                .callback("http%3A%2F%2Flocalhost%3A8080%2Fcallback")
                //  .callback("http://localhost:8080/callback")
                .build();

        String accessToken = service.getAccessToken(code);

         String result = "";
        String line="";
        String urlNameString = "https://api.github.com/user?access_token="+accessToken;
        URL realUrl = new URL(urlNameString);
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

        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream(),"utf-8"));
        while ((line = in.readLine()) != null) {
            result += line;
        }

       // Charset charset = Charset.forName()

        //  BufferedOutputStream()
        // 字节OutputStream

        //Writer
        // 字符串
       String id = MyGsonLib.asObject(result,"id",String.class);
        out.write(id);

    }



}
