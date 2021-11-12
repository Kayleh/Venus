package com.kayleh.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 载荷
 * @Author: Kayleh
 * @Date: 2021/11/12 14:50
 * @Since: 1.0.0
 */
@Data
public class Payload <T>{
    private String id;
    private T userInfo;
    private Date expiration;
}
