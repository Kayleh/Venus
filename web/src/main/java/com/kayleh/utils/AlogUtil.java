package com.kayleh.utils;

/**
 * @Description:
 * @Author: Kayleh
 * @Date: 2021/9/6 10:52
 * @Since: 1.0.0
 */
public class AlogUtil {
    /*
     * 位运算
     * 左移1位 就是 （原数 × 2）
     * 左移n位 就是 （原数 × 2的n次方）
     */
    public int leftMove(int num, int bit) {
        return num << bit;
    }

    /*
     * 位运算
     * 右移1位 就是 （原数 ÷ 2）
     * 右移n位 就是 （原数 ÷ 2的n次方）
     */
    public int rightMove(int num, int bit) {
        return num >> bit;
    }

    /*
    置零
     */
    public int zero(int num) {
        return num &= 0;
    }

    /**
     * 交换值
     * //        int a = 100;
     * //        int b = 1;
     * //        a = a ^ b;
     * //        //   a= 101,b=1
     * //
     * //        b = b ^ a;
     * //        //   a= 101,b=100
     * //
     * //        a = a ^ b;
     * //        //   a= 1, b=100
     */
    public void swap(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
    }

    /**
     * 取相反数
     */
    public int reverse(int num) {
        return ~num + 1;
    }

    /**
     * 输出某个数的二进制数
     *
     * @param num
     * @return
     */
    public String binaryStr(int num) {
        return Integer.toBinaryString(num);
    }

    /**
     * 检查第n个位置是不是1
     *
     * @param num
     */
    public int checkOne(int num, int n) {
        return num & (1 << n);
    }

    /**
     * 把第n个位置设置为1
     *
     * @param num
     */
    public int setOne(int num, int n) {
        return num | (1 << n);
    }

    /**
     * 把第n个位置设置为0
     *
     * @param num
     */
    public int switchO(int num, int n) {
        return num & ~(1 << n);
    }

    /**
     * 开关第n个位置
     *
     * @param num
     */
    public int switchOne(int num, int n) {
        return num ^ (1 << n);
    }

    /**
     * 与运算（&）
     * 1、与0相与可清零
     * 2、与1相与可保留原值
     * 或运算（|）
     * 1、与0相或可保留原值
     * 2、与1相与可齐设1
     * 异或运算（^）
     * 1、与0异或保留原值
     * 2、与1异或比特值反转
     * 3、可通过某种算法，使用异或实现交换两个值
     * 异或运算是有结合律的
     * 取反（~）
     */

    public static void main(String[] args) {
        System.out.println(~-1);

    }

}
