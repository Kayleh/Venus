package com.kayleh.domain;

import lombok.Data;

/**
 * @Author: Kayleh
 * @Date: 2020/12/9 0:01
 */
@Data
public class Order {
    private Long id;
    private Long userId;//用户ID
    private Long orderId;//订单ID
}
