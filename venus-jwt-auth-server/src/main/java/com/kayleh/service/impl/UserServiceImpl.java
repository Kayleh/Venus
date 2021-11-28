package com.kayleh.service.impl;

import com.kayleh.domain.RolePojo;
import com.kayleh.domain.UserPojo;
import com.kayleh.mapper.UserMapper;
import com.kayleh.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserPojo user = mapper.queryByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("not found");
        }
        //定义权限列表.
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<RolePojo> rolePojos = mapper.queryRoleByUserId(user.getId());
        user.setRoles(rolePojos);
        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
        if (rolePojos.isEmpty()){
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }else{
            rolePojos.stream().parallel().forEachOrdered(rolePojo -> authorities.add(new SimpleGrantedAuthority("ROLE_" + rolePojo.getRoleName())));
        }
        UserDetails build = User.withUsername(user.getUsername()).password(user.getPassword()).authorities(authorities).build();
        User user1 = new User(user.getUsername(), user.getPassword(), authorities);
        return user1;
    }
}
