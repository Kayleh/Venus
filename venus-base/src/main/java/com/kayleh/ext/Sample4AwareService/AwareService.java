package com.kayleh.ext.Sample4AwareService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * @desp: Spring Aware容器感知技术
 * Spring Aware的目的是为了让Bean获得Spring容器的服务。因为ApplicationContext接口集成了MessageSource接口，
 * ApplicationEventPublisherAware接口和ResourceLoaderAware接口，
 * 所以Bean继承ApplicationContextAware可以获得Spring容器的所有服务，但原则上我们还是用到什么接口就实现什么接口。
 * <p>
 * 生效后置条件 --配置类、启动类
 * @author: power by Kayleh, 2021/12/12 15:39
 * @params:
 * @return:
 * @since: 1.0.0
 */
@Service
@Slf4j
public class AwareService implements BeanNameAware, ResourceLoaderAware, EnvironmentAware//实现BeanNameAware,ResourceLoaderAware接口，获得Bean名称和资源加载的服务。
{
    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    @Override
    public void setBeanName(String name) {//③
        this.beanName = name;
    }

    public void outputResult() {
        log.info("Bean的名称为：" + beanName);

        Resource resource = loader.getResource("classpath:/META-INF/spring.factories");
        try {
            log.info("ResourceLoader加载的文件内容为: " + (resource.getInputStream()));
            //log.info("ResourceLoader加载的文件内容为: " + IOUtils.toString(resource.getInputStream()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        //凡注册到Spring容器内的bean，实现了EnvironmentAware接口重写setEnvironment方法后，在工程启动时可以获得application.properties的配置文件配置的属性值。
        String projectName = environment.getProperty("project.name");
        log.info("项目：" + projectName);
    }
}
