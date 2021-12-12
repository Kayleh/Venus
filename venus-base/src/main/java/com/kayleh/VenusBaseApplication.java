package com.kayleh;

import com.kayleh.ext.Sample1ApplicationContextInitializer;
import com.kayleh.ext.Sample4AwareService.AwareConfig;
import com.kayleh.ext.Sample4AwareService.AwareService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class VenusBaseApplication
{
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(VenusBaseApplication.class);

        //region
        springApplication.addInitializers(new Sample1ApplicationContextInitializer());
        //endregion

        //region awera
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();

        //endregion
        springApplication.run(args);
    }

}
