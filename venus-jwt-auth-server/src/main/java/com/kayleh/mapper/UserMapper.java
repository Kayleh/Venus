package com.kayleh.mapper;

import com.kayleh.domain.RolePojo;
import com.kayleh.domain.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    UserPojo queryByUserName(@Param("userName") String userName);


    List<RolePojo> queryRoleByUserId(@Param("userId") Long userId);
}
