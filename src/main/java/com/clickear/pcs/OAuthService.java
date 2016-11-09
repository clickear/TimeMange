package com.clickear.pcs;


import com.github.scribejava.core.model.OAuthConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OAuthService {

    private OAuthBuilder builder;

    public OAuthService(OAuthBuilder builder){
        this.builder = builder;
    }



    /***
     * 获取token
     * @param code
     */
    public String getAccessToken(String code) throws IOException {

        // 1.添加头信息
        Map<String,String> addParmer = new HashMap<String,String>();
    //    addParmer.put(OAuthConstants.RESPONSE_TYPE, builder.getResponseType());
        addParmer.put("grant_type","authorization_code");
        addParmer.put(OAuthConstants.CLIENT_ID, builder.getApiKey());
        addParmer.put(OAuthConstants.CLIENT_SECRET,builder.getApiSecret());
        addParmer.put("code",code);

        final String callback = builder.getCallback();
        if (callback != null) {
            addParmer.put(OAuthConstants.REDIRECT_URI, callback);
        }

        final String scope = builder.getScope();
        if (scope != null) {
            addParmer.put(OAuthConstants.SCOPE, scope);
        }

        final String state = builder.getState();
        if (state != null) {
            addParmer.put(OAuthConstants.STATE, state);
        }

        String headParm = "";
        for (String key : addParmer.keySet()) {
            System.out.println(key + "--->" + addParmer.get(key));
            if(headParm.indexOf('?')>=0){
                headParm += "&"+ key+"="+ addParmer.get(key);
            }else{
                headParm += "?"+ key+"="+ addParmer.get(key);
            }
        }

        // 2.发送请求获取消息
        String interfaceUrl = builder.getAccessTokenEndpoint()+headParm;
        System.out.println(interfaceUrl);
        URL realUrl = new URL(interfaceUrl);
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
        String result = "";
        while ((line = in.readLine()) != null) {
            result += line;
        }
        System.out.println(result);
        String[] m_parm = result.split("&");
        String accesToken = "";
        for(String m_key :m_parm) {
            if (m_key.indexOf('=') > 0) {
                String m_k = m_key.substring(0, m_key.indexOf('='));
                String m_v = m_key.substring(m_key.indexOf('=') + 1);
                if (m_k.equals("access_token")) {
                    accesToken = m_v;
                }
            }


        }
        return  accesToken;
        // 3.获取accesstoken




    }





}
