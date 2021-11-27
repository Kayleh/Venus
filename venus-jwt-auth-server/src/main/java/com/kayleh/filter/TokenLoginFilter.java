package com.kayleh.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kayleh.config.RsaKeyProperties;
import com.kayleh.domain.RolePojo;
import com.kayleh.domain.UserPojo;
import com.kayleh.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @desp: 自定义认证过滤器
 * @author: power by Kayleh, 2021/11/15 14:30
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private RsaKeyProperties prop;

    public TokenLoginFilter(AuthenticationManager authenticationManager, RsaKeyProperties prop) {
        this.authenticationManager = authenticationManager;
        this.prop = prop;
    }

    /**
     * @desp: 尝试验证
     * @author: power by Kayleh, 2021/11/15 14:46
     * @params: [request, response]
     * @return: org.springframework.security.core.Authentication
     * @since: 1.0.0
     */
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserPojo sysUser = new ObjectMapper().readValue(request.getInputStream(), UserPojo.class);

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword());
            return authenticationManager.authenticate(authRequest);
        } catch (Exception e) {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                Map resultMap = new HashMap();
                resultMap.put("code", HttpServletResponse.SC_UNAUTHORIZED);
                resultMap.put("msg", "用户名或密码错误！");
                out.write(new ObjectMapper().writeValueAsString(resultMap));
                out.flush();
                out.close();
            } catch (Exception outEx) {
                outEx.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    /**
     * @desp: 验证成功操作
     * @author: power by Kayleh, 2021/11/15 14:47
     * @params: [request, response, chain, authResult]
     * @return: void
     * @since: 1.0.0
     */
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserPojo user = new UserPojo();
        user.setUsername(authResult.getName());
        List<RolePojo> list = new ArrayList<>();
        for (GrantedAuthority authority : authResult.getAuthorities()) {
            RolePojo rolePojo = new RolePojo();
            rolePojo.setRoleName(authority.getAuthority());
            list.add(rolePojo);
        }
        //user.setRoles((List<RolePojo>) authResult.getAuthorities());
        user.setRoles(list);
        String token = JwtUtils.generateTokenExpireInMinutes(user, prop.getPrivateKey(), 24 * 60);
        response.addHeader("Authorization", "Bearer " + token);
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map resultMap = new HashMap();
            resultMap.put("code", HttpServletResponse.SC_OK);
            resultMap.put("msg", "认证通过！");
            out.write(new ObjectMapper().writeValueAsString(resultMap));
            out.flush();
            out.close();
        } catch (Exception outEx) {
            outEx.printStackTrace();
        }
    }
}
