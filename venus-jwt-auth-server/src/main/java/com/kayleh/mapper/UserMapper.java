package com.kayleh.mapper;

import com.kayleh.domain.UserPojo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public UserPojo queryByUserName(@Param("userName") String userName);
}
