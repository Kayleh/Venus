### MyBatisPlus

一、 CodeGenerator 

》使用代码生成器生成实体类、dao、controller等等。

1.MAVEN

```xml
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.2.0</version>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus</artifactId>
        <version>3.4.3.4</version>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-generator</artifactId>
        <version>3.5.1</version>
    </dependency>
    <!--代码生成所依赖模板-->
    <dependency>
        <groupId>org.freemarker</groupId>
        <artifactId>freemarker</artifactId>
        <version>2.3.30</version>
    </dependency>
    <!--        jdbc-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.27</version>
    </dependency>
```

2、生成代码类

```java
public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://192.168.188.108:8083/venus", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("kayleh") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://project//Venus//venus-common//src//main//java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("kayleh") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://project//Venus//venus-common//src//main//resources//mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addTablePrefix("t_", "c_")// 设置过滤表前缀
                            .entityBuilder() //实体类策略
                            .versionColumnName("version")//乐观锁字段名(数据库)
                            .versionPropertyName("version")
                            .enableTableFieldAnnotation()//开启生成实体时生成字段注解
                            .logicDeleteColumnName("deleted")    //逻辑删除字段名(数据库)
                            .logicDeletePropertyName("deleted")    //逻辑删除属性名(实体)
//                           .addIgnoreColumns(String...)  添加忽略字段
//                            .idType(IdType.AUTO)
                    ;

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
```

运行代码后，就能自动根据数据库生成代码了。

二、CRUD

