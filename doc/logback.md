logback+slf4j日志

```xml

<dependencies>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>jcl-over-slf4j</artifactId>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>log4j-over-slf4j</artifactId>
    </dependency>
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
    </dependency>
</dependencies>
```

配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="60 seconds" debug="false">
    <!--用于区分不同应用程序的记录-->
    <contextName>edu-cloud</contextName>
    <!--日志文件所在目录，如果是tomcat，如下写法日志文件会在则为${TOMCAT_HOME}/bin/logs/目录下-->
    <property name="LOG_HOME" value="logs"/>

    <!--控制台-->
    <appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度 %logger输出日志的logger名 %msg：日志消息，%n是换行符 -->
            <pattern>[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%thread] %-5level %logger{36} : %msg%n</pattern>
            <!--解决乱码问题-->
            <charset>UTF-8</charset>
        </encoder>
    </appender>

    <!--滚动文件-->
    <appender name="infoFile" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- ThresholdFilter:临界值过滤器，过滤掉 TRACE 和 DEBUG 级别的日志 -->
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>INFO</level>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_HOME}/log.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>30</maxHistory><!--保存最近30天的日志-->
        </rollingPolicy>
        <encoder>
            <charset>UTF-8</charset>
            <pattern>[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%thread] %-5level %logger{36} : %msg%n</pattern>
        </encoder>
    </appender>

    <!--滚动文件-->
    <appender name="errorFile" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- ThresholdFilter:临界值过滤器，过滤掉 TRACE 和 DEBUG 级别的日志 -->
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>error</level>
        </filter>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_HOME}/error.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>30</maxHistory><!--保存最近30天的日志-->
        </rollingPolicy>
        <encoder>
            <charset>UTF-8</charset>
            <pattern>[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%thread] %-5level %logger{36} : %msg%n</pattern>
        </encoder>
    </appender>
    <!--这里如果是info，spring、mybatis等框架则不会输出：TRACE < DEBUG < INFO <  WARN < ERROR-->
    <!--root是所有logger的祖先，均继承root，如果某一个自定义的logger没有指定level，就会寻找
    父logger看有没有指定级别，直到找到root。-->
    <root level="debug">
        <appender-ref ref="stdout"/>
        <appender-ref ref="infoFile"/>
        <appender-ref ref="errorFile"/>
        <appender-ref ref="logstash"/>
    </root>
</configuration>
```

在进行配置的时候，主要要理解或记住以下几点（主要标签的用处）：

- appender，负责定义日志的输出目的地（控制台、日志文件、滚动日志文件，其他如logstash等）。
- encoder负责定义日志的输出样式和字符编码，如果在控制台出现?????或乱码，则指定编码（一般是UTF-8）就好了。
- filter负责过滤日志，即使logger传来了dubug级别以上的日志，如果filter中设定了级别为info，则该appender只会将info级别及以上的日志输出到目的地。
- rollingPolicy负责制定日志文件的滚动规则，是根据日志文件大小还是根据日期进行滚动。
- logger，负责定义我们实际代码中使用的logger。logger中有一个非常重要的属性name，name必须指定。在logback中，logger有继承关系，而所有的logger的祖先是root。

```java
//配合lombok使用更简单
@Slf4j
public class UserServiceImpl
{
    static {
        log.info("hi");
    }
}
```

