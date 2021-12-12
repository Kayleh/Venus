//package com.kayleh.ext.Sample4AwareService;
//
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
// aware应用
//@Configuration
//public class MyBatisConfig implements EnvironmentAware
//{
//    private Environment environment;
//
//    @Override
//    public void setEnvironment(final Environment environment) {
//        this.environment = environment;
//    }
//
//    /**
//     * 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名       称,该名称也就是数据源的名称)
//     */
//    @Bean
//    public DataSource druidDataSource() throws Exception {
//        Properties props = new Properties();
//        props.put("driverClassName", environment.getProperty("datasource.driverClassName"));
//        props.put("url", environment.getProperty("datasource.url"));
//        props.put("username", environment.getProperty("datasource.username"));
//        props.put("password", environment.getProperty("datasource.password"));
//        return DruidDataSourceFactory.createDataSource(props);
//    }
//
//    /**
//     * 根据数据源创建SqlSessionFactory
//     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        // 指定数据源(这个必须有，否则报错)
//        fb.setDataSource(druidDataSource());
//        fb.setTypeAliasesPackage("com.tf56.pushService.dal.domain");
//        // 指定mapper文件          　　　　 fb.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//        return fb.getObject();
//    }
//
//}
