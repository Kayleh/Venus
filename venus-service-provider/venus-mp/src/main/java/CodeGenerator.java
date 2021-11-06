import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://192.168.188.108:8083/venus", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("kayleh") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://project//Venus//venus-service-provider//venus-mp//src//main//java//"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("kayleh") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://project//Venus//venus-service-provider//venus-mp//src//main//resources//mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addTablePrefix("t_", "c_")// 设置过滤表前缀
                            .entityBuilder() //实体类策略
                            .versionColumnName("version")//乐观锁字段名(数据库)
                            .versionPropertyName("version")
                            .enableTableFieldAnnotation()//开启生成实体时生成字段注解
                            .logicDeleteColumnName("deleted")    //逻辑删除字段名(数据库)
                            .logicDeletePropertyName("deleted")    //逻辑删除属性名(实体)
//                           .addIgnoreColumns(String...)	添加忽略字段
//                            .idType(IdType.AUTO)
                    ;

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
