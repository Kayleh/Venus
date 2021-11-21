package com.kayleh.mapper;

import com.kayleh.domain.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public UserPojo queryByUserName(@Param("userName") String userName);

    int addUser(UserPojo user);
}
