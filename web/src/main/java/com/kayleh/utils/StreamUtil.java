package com.kayleh.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Description: 流工具
 * @Author: Kayleh
 * @Date: 2021/8/19 14:56
 * @Version: 1.0
 */
public class StreamUtil {
    private StreamUtil() {
    }//防止实例化

    /**
     * String to Int
     *
     * @param input
     * @return
     */
    public static Integer string2int(String input) {
        Function<String, Integer> s = Integer::parseInt;
        return s.apply(input);
    }

    /**
     * 筛选integers中，所有小于flag的值，并返回为数组
     *
     * @param flag     设置值
     * @param integers integers 可以是数组，可以是多个参数
     * @return
     */
    public static List<Integer> ints2Array(Integer flag, Integer... integers) {
        Stream<Integer> integerStream = Stream.of(integers);
        return integerStream.filter(s -> s.intValue() < 7).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    /**
     * 求和
     *
     * @param integers 可变参数
     * @return
     */
    public static Integer sum(Integer... integers) {
        Stream<Integer> integerStream = Stream.of(integers);
        return integerStream.reduce(0, (x, y) -> x + y);
    }

    public static void main(String[] args) {
        List<Integer> integers = ints2Array(0, 1);
        System.out.println(integers.toString());
    }

}
