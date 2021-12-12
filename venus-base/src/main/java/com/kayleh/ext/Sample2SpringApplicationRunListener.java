package com.kayleh.ext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @desp: Spring启动监听
 * @author: power by Kayleh, 2021/12/11 21:51
 * <p>
 * 后置条件：
 * 还要满足SpringFactoriesLoader的约定，在当前SpringBoot项目的classpath下新建META-INF目录，并在该目录下新建spring.fatories文件，文件内容如下:
 * org.springframework.boot.SpringApplicationRunListener=\
 * com.dxz.SampleSpringApplicationRunListener
 */
@Slf4j
public class Sample2SpringApplicationRunListener implements SpringApplicationRunListener
{
    private final SpringApplication application;
    private final String[] args;

    public Sample2SpringApplicationRunListener(SpringApplication sa, String[] args) {
        this.application = sa;
        this.args = args;
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("创建并准备好ApplicationContext，准备加载源...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("加载应用程序上下文完成，准备刷新...");
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        log.info("调用 run 方法第一次启动, 非常早的初始化...");
        SpringApplicationRunListener.super.starting(bootstrapContext);
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        log.info("环境准备好，准备创建ApplicationContext...");
        SpringApplicationRunListener.super.environmentPrepared(bootstrapContext, environment);
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("上下文已刷新且应用程序已启动，准备调用CommandLineRunners和ApplicationRunners...");
        SpringApplicationRunListener.super.started(context);
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("调用 run 方法完成，应用程序上下文已刷新并且所有CommandLineRunners和ApplicationRunners已被调用。");
        SpringApplicationRunListener.super.running(context);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("在运行应用程序时发生故障");
        SpringApplicationRunListener.super.failed(context, exception);
    }

//    public void finished(ConfigurableApplicationContext context, Throwable exception) {
//        log.info("自定义finished");
//    }
}
