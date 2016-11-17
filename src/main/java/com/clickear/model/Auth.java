package com.clickear.model;

/**
 * Created by Administrator on 2016/11/17.
 */
public class Auth {
    private long auth_id;
    private String apiKey;
    private String apiSecret;
    private String callback;
    private String accesstokenUrl;
    private String accesstokenAuthUrl;
    private String authCode;
    private int authType;
    private String authName;
    private String authCheckCode;
    private String authCheckUrl;

    public long getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(long auth_id) {
        this.auth_id = auth_id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getAccesstokenUrl() {
        return accesstokenUrl;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setAccesstokenUrl(String accesstokenUrl) {
        this.accesstokenUrl = accesstokenUrl;
    }

    public String getAccesstokenAuthUrl() {
        return accesstokenAuthUrl;
    }

    public void setAccesstokenAuthUrl(String accesstokenAuthUrl) {
        this.accesstokenAuthUrl = accesstokenAuthUrl;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public int getAuthType() {
        return authType;
    }

    public void setAuthType(int authType) {
        this.authType = authType;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthCheckCode() {
        return authCheckCode;
    }

    public void setAuthCheckCode(String authCheckCode) {
        this.authCheckCode = authCheckCode;
    }

    public String getAuthCheckUrl() {
        return authCheckUrl;
    }

    public void setAuthCheckUrl(String authCheckUrl) {
        this.authCheckUrl = authCheckUrl;
    }


}
