package com.kayleh.ext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @desp: 所有CommandLineRunner的执行时间点是在SpringBoot应用的Application完全初始化工作之后(这里我们可以认为是SpringBoot应用启动类main方法执行完成之前的最后一步)。
 * 当前SpringBoot应用的ApplicationContext中的所有CommandLinerRunner都会被加载执行(无论是手动注册还是被自动扫描注册到IoC容器中)。
 * <p>
 * 应用场景：加载数据库数据到缓存
 * @author: power by Kayleh, 2021/12/12 15:22
 */
@Component
@Order(value = 1)
@Slf4j
public class Sample3StartupRunner implements CommandLineRunner//ApplicationRunner接口也可以实现
{
    @Override
    public void run(String... strings) throws Exception {
        log.info("SpringBoot应用的Application完全初始化已完成,服务启动执行");
    }
}
