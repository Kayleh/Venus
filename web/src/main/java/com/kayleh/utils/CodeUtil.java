package com.kayleh.utils;

/**
 * @Description: 链式操作
 * @Author: Kayleh
 * @Date: 2021/9/6 0:08
 * @Since: 1.0.0
 */
public class CodeUtil {
    private static int sum = 0;

    public CodeUtil set(int i) {
        sum += i;
        return this;
    }

    public int get() {
        return sum;
    }


    public static void main(String[] args) {
        CodeUtil codeUtil = new CodeUtil();
        int i = codeUtil.get();
        System.out.println(i);
        int set = codeUtil.set(1).set(1).get();
        System.out.println(set);

    }
}
