package com.clickear.pcs;

import java.io.IOException;

/**
 * Created by Administrator on 2016/11/9.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        OAuthService service = new OAuthBuilder()
                                .accessTokenEndpoint("https://github.com/login/oauth/access_token")
                                .apiKey("c774a0b7d7c450193689")
                                .apiSecret("0a8cf7435cf2b5a9bc857c9643f608efe967ea01")
                                .callback("http%3A%2F%2Flocalhost%3A8080%2Fcallback")
                              //  .callback("http://localhost:8080/callback")
                                .build();

        service.getAccessToken("71f636785452caf1e563");
    }
}
