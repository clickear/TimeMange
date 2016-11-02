package com.clickear.servlet;

import com.google.gson.*;
import org.joda.time.DateTime;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2016/10/24.
 */
public class TimestampTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    public JsonElement serialize(Date ts, Type t, JsonSerializationContext jsc) {
        DateTime dateTime = new DateTime(ts);
        String dfString = dateTime.toString();
        return new JsonPrimitive(dfString);
    }
    public Date deserialize(JsonElement json, Type t, JsonDeserializationContext jsc) throws JsonParseException {
        if (!(json instanceof JsonPrimitive)) {
            throw new JsonParseException("The date should be a string value");
        }
        try {
            return new DateTime(json.getAsString()).toDate();
        } catch (Exception e) {
            throw new JsonParseException("");
        }
    }
}
