package com.venus.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.venus.common.config.VenusConfig;
import lombok.Data;

import java.io.IOException;
import java.util.Map;

public class JsonUtil {

    public static String toJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String toJson(Object object, String... excludeParamNames) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(excludeParamNames);
            FilterProvider filters = new SimpleFilterProvider().addFilter("propertyFilter", filter);
            return objectMapper.writer(filters).writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static <T> T toObject(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObject(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return (T) objectMapper.readValue(json, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
