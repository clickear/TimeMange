package com.clickear.sample;

import com.clickear.utils.MyGsonLib;
import com.google.gson.*;

import java.util.List;

/**
 * Created by Administrator on 2016/11/15.
 */
public class TestGJson {



    public static void main(String[] args) {
       String formatStr = "" +
               "{\"menu\": {\n" +
               "  \"id\": \"file\",\n" +
               "  \"value\": \"12\",\n" +
               "  \"popup\": {\n" +
               "    \"menuitem\": [\n" +
               "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
               "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
               "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
               "    ]\n" +
               "  }\n" +
               "}}";

        TestClass jsonElement1 = MyGsonLib.asObject(formatStr,"menu.popup.menuitem[2]",TestClass.class);



        System.out.println(jsonElement1.getOnclick());


    }
}
