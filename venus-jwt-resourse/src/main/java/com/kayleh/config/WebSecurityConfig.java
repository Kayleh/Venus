package com.kayleh.config;

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
 * SpringSecurity配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)//启用注解控制
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    private UserService userService;

    @Autowired
    private RsaKeyProperties prop;

    //    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
    //  addJsonArray("authorList", authorList.stream().map(TbQyProductAuthorPO::getPersonName).distinct().collect(Collectors.toList()));
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
                //必须先声明范围小的，再声明范围大的
                .antMatchers("/").permitAll()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login.html").failureUrl("/login.html").defaultSuccessUrl("/").permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .and()
                //.formLogin().loginPage("/login").loginProcessingUrl("/login_check").failureUrl("/login").defaultSuccessUrl("/index").permitAll()
                //.formLogin().loginPage("/login.html").defaultSuccessUrl("/index").permitAll()
                //.and()
                .addFilter(new TokenVerifyFilter(super.authenticationManager(), prop))
                // 禁用掉session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}

