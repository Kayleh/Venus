package com.kayleh.config;

import com.kayleh.filter.TokenLoginFilter;
import com.kayleh.filter.TokenVerifyFilter;
import com.kayleh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity的配置类
 */
@Configuration// 将当前类标记为配置类
@EnableWebSecurity// 启用Web环境下权限控制功能
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private RsaKeyProperties prop;

    //    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //指定认证对象的来源
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    //SpringSecurity配置信息
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/user/*").hasAnyRole("ADMIN","USER")
                .antMatchers("/admin/*").hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new TokenLoginFilter(super.authenticationManager(), prop))
                .addFilter(new TokenVerifyFilter(super.authenticationManager(), prop))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


//        @Override
//        protected void configure(HttpSecurity security) throws Exception {
//            security
//                    .authorizeRequests()                    // 对请求进行授权
//                    .antMatchers("/index.jsp")  // 针对/index.jsp路径进行授权
//                    .permitAll()                            // 可以无条件访问
//                    .antMatchers("/layui/**")   // 表示layui下的任意资源
//                    .permitAll()                            // 可无条件访问
//                    .and()
//                    .authorizeRequests()                    // 对请求进行授权
//                    .anyRequest()                           // 任意请求
//                    .authenticated()                        // 需要登陆之后才可访问
//                    .and()
//                    .formLogin()                            // 使用表单的形式登陆
//                    // 关于loginPage：会影响到提交表单的地址，退出登陆地址，登陆失败地址
//                    .loginPage("/index.jsp")                // 指定登陆页面(如果没有指定会访问Security自带的)
//
//                    // 指定了loginProcessingUrl，就会覆盖loginPage方法中设置的默认值
//                    .loginProcessingUrl("/do/login.html")   // 指定提交登录表单的地址
//            ;
//        }
//    }
}
