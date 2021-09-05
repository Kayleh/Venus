package com.kayleh.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/8/19 15:06
 * @Version: 1.0
 */
public class DateFormatUtils {
    //函数式接口
    @FunctionalInterface
    public interface KiteFunction<T, R, S> {
        /**
         * 定义一个双参数的方法
         *
         * @param t
         * @param s
         * @return
         */
        R run(T t, S s);
    }

    public static String localDateFormat(LocalDateTime dateTime, String partten) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(partten);
        return dateTime.format(dateTimeFormatter);
    }

    public static String DateFormat(Date dateTime, String partten) {
        DateFormat dateFormat = new SimpleDateFormat(partten);
        return dateFormat.format(dateTime);
    }

    /**
     * datetime转string
     *
     * @param date
     * @return
     */
    public static String date2string(Date date) {
        KiteFunction<Date, String, String> functionDateFormat = DateFormatUtils::DateFormat;
        return functionDateFormat.run(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static void main(String[] args) {
        System.out.println(date2string(new Date()));
    }
}
