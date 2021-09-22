package com.kayleh.utils;

import java.util.List;
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
}
