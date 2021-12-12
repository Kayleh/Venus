package com.kayleh.ext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @Description: 整个spring容器在刷新之前初始化ConfigurableApplicationContext的回调接口，
 * 简单来说，就是在容器刷新之前调用此类的initialize方法。这个点允许被用户自己扩展。
 * 用户可以在整个spring容器还没被初始化之前做一些事情。
 * 可以想到的场景可能为，在最开始激活一些配置，或者利用这时候class还没被类加载器加载的时机，进行动态字节码注入等操作。
 * <p>
 * 后置条件：在启动类中用springApplication.addInitializers(new TestApplicationContextInitializer())语句加入
 * @Author: Kayleh
 * @Date: 2021/12/11 21:33
 * @Since: 1.0.0
 */
//@Order的value值越小->越早执行。注：在类上标注，不是方法上
@Order(1)
@Slf4j
public class Sample1ApplicationContextInitializer implements ApplicationContextInitializer
{
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("         ,-.                              ,--,                 ,---,");
        log.info("     ,--/ /|                            ,--.'|               ,--.' |");
        log.info("   ,--. :/ |                            |  | :               |  |  :");
        log.info("   :  : ' /                             :  : '               :  :  :");
        log.info("   |  '  /       ,--.--.          .--,  |  ' |       ,---.   :  |  |,--.");
        log.info("   '  |  :      /       \\       /_ ./|  '  | |      /     \\  |  :  '   |");
        log.info("   |  |   \\    .--.  .-. |   , ' , ' :  |  | :     /    /  | |  |   /' :");
        log.info("   '  : |. \\    \\__\\/: . .  /___/ \\: |  '  : |__  .    ' / | '  :  | | |");
        log.info("   |  | ' \\ \\   ,\" .--.; |   .  \\  ' |  |  | '.'| '   ;   /| |  |  ' | :");
        log.info("   '  : |--'   /  /  ,.  |    \\  ;   :  ;  :    ; '   |  / | |  :  :_:,'");
        log.info("   ;  |,'     ;  :   .'   \\    \\  \\  ;  |  ,   /  |   :    | |  | ,'");
        log.info("   '--'       |  ,     .-./     :  \\  \\  ---`-'    \\   \\  /  `--''");
        log.info("               `--`---'          \\  ' ;             `----'");
        log.info("                                  `--`");
        log.info(" CopyRight© Kayleh   ");
        log.info("Venus fast develop platform start...                       \n\n");
        log.info("Spring容器准备初始化... ");

        // 打印容器里面有多少个bean
        log.info("↓容器内bean数量：" + applicationContext.getBeanDefinitionCount());

        // 打印所有 beanName
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            log.info(beanName);
        }
    }
}
