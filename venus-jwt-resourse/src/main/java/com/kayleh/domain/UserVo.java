package com.kayleh.domain;

import lombok.Data;

/**
 * @Description: 当前登录对象
 * @Author: Kayleh
 * @Date: 2021/11/28 13:09
 * @Since: 1.0.0
 */
@Data
public class UserVo {
    private Long id;
    private String username;
    private String password;
}
