package com.clickear.sample;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.GetFileLocalRequest;
import com.qcloud.cos.request.ListFolderRequest;
import com.qcloud.cos.sign.Credentials;

/**
 * Created by Administrator on 2016/11/18.
 */
public class TestStorage {

    public static void main(String[] args) {
        long appId = 1251684749;
        String secretId = "AKIDxnTxFMv3sz0pW1uQN8h6JOJ22DF85ZBc";
        String secretKey = "NZTDm9JH4fgliU6VhhV8bu0tthcQ2Xv7";
        // 设置要操作的bucket
        String bucketName = "cloudstorage";
        // 初始化秘钥信息
        Credentials cred = new Credentials(appId, secretId, secretKey);

        // 初始化客户端配置
        ClientConfig clientConfig = new ClientConfig();
        // 设置bucket所在的区域，比如广州(gz), 天津(tj)
        clientConfig.setRegion("tj");

        // 初始化cosClient
        COSClient cosClient = new COSClient(clientConfig, cred);


        ListFolderRequest listFolderRequest = new ListFolderRequest(bucketName, "/");
        String listFolderRet = cosClient.listFolder(listFolderRequest);

        System.out.printf(listFolderRet);

    }
}
