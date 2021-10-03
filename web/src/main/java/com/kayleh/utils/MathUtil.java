package com.kayleh.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Description: 数学工具
 * @Author: Kayleh
 * @Date: 2021/9/17 20:48
 * @Since: 1.0.0
 */
public class MathUtil {

    /*
        取交集
        场景： 数据库有的数据，入参里面也有(更新)
     */
    public List<String> Intersection(List<String> dao, List<String> dto) {
        return dao.stream().parallel().filter(dto::contains).collect(Collectors.toList());
    }

    /*
        A集合中有但B集合里面没有的数据

        场景： 数据库有的数据，但入参里没有的数据，需要做数据清洗(删除)
     */
    public List<String> leftJoin(List<String> dao, List<String> dto) {
        return dao.stream().filter(s -> !dto.contains(s)).collect(Collectors.toList());
    }

    /*
        B集合中有但A集合里面没有的数据

        场景： 数据库没有的数据，但入参里有的数据(插入)
     */
    public List<String> rightJoin(List<String> dao, List<String> dto) {
        return dto.stream().filter(s -> !dao.contains(s)).collect(Collectors.toList());
    }


    /*
         获取 size间隙内，cap个随机不同的整数
     */
    public static List<Integer> randomIndex(int size, int cap) {
        List<Integer> randomList = new ArrayList<>();
        if (size < cap) cap = size;//如果size比要获取的数量cap少，会进入死循环
        Random r = new Random();
        for (int i = 0; i < cap; i++) {
            int j = r.nextInt(size);
            while (randomList.contains(j)) {
                j = r.nextInt(size);
            }
            randomList.add(j);
        }
        return randomList;

    }
}
