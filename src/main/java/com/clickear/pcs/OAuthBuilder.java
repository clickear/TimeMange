package com.clickear.pcs;

import com.github.scribejava.core.model.HttpClient;
import com.github.scribejava.core.model.SignatureType;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Parameter object that groups OAuth config values
 */
public class OAuthBuilder {

    private String apiKey;
    private String apiSecret;
    private String callback;
    private SignatureType signatureType;
    private String scope;
    private OutputStream debugStream;
    private String state;
    private String responseType ;
    private String userAgent;

    private  String version;
    private  String host;
    private String authorizationBaseUrl;
    private String accessTokenEndpoint;

    //sync only version
    private final Integer connectTimeout;
    private final Integer readTimeout;

    //async version only
    private HttpClient.Config httpClientConfig;
    private HttpClient httpClient;

    public OAuthBuilder(){
        this(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public String getAuthorizationBaseUrl() {
        return authorizationBaseUrl;
    }

    public OAuthBuilder authorizationBaseUrl(String authorizationBaseUrl) {
        this.authorizationBaseUrl = authorizationBaseUrl;
        return  this;
    }

    public String getAccessTokenEndpoint() {
        return accessTokenEndpoint;
    }

    public OAuthBuilder accessTokenEndpoint(String accessTokenEndpoint) {
        this.accessTokenEndpoint = accessTokenEndpoint;
        return  this;
    }

    public OAuthBuilder(String key, String secret) {
        this(key, secret, null, null, null, null, null, null, null, null, null, null, null);
    }

    public OAuthBuilder(String apiKey, String apiSecret, String callback, SignatureType signatureType, String scope,
                       OutputStream debugStream, String state, String responseType, String userAgent, Integer connectTimeout,
                       Integer readTimeout, HttpClient.Config httpClientConfig, HttpClient httpClient) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.callback = callback;
        this.signatureType = signatureType;
        this.scope = scope;
        this.debugStream = debugStream;
        this.state = state;
        this.responseType = responseType;
        this.userAgent = userAgent;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.httpClientConfig = httpClientConfig;
        this.httpClient = httpClient;
    }

    public OAuthBuilder apiKey(String apiKey) {
        this.apiKey = apiKey;
        return  this;
    }

    public OAuthBuilder apiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
        return  this;
    }

    public OAuthBuilder callback(String callback) {
        this.callback = callback;
        return  this;
    }

    public OAuthBuilder signatureType(SignatureType signatureType) {
        this.signatureType = signatureType;
        return  this;
    }

    public OAuthBuilder scope(String scope) {
        this.scope = scope;
        return  this;
    }

    public OAuthBuilder debugStream(OutputStream debugStream) {
        this.debugStream = debugStream;
        return  this;
    }

    public OAuthBuilder state(String state) {
        this.state = state;
        return  this;
    }

    public OAuthBuilder responseType(String responseType) {
        this.responseType = responseType;
        return  this;
    }

    public OAuthBuilder userAgent(String userAgent) {
        this.userAgent = userAgent;
        return  this;
    }

    public OAuthBuilder httpClientConfig(HttpClient.Config httpClientConfig) {
        this.httpClientConfig = httpClientConfig;
        return  this;
    }

    public OAuthBuilder httpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return  this;
    }

    public OAuthService build() {
        return new OAuthService(this);
    }


    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public String getCallback() {
        return callback;
    }

    public SignatureType getSignatureType() {
        return signatureType;
    }

    public String getScope() {
        return scope;
    }

    public String getState() {
        return state;
    }

    public String getResponseType() {
        return responseType;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public HttpClient.Config getHttpClientConfig() {
        return httpClientConfig;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

}
