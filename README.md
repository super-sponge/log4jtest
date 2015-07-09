log4j-flume-ng 测试
===========================

#目的
    通过配置log4j配置文件,使基于log4j的日志系统直接发送数据到flume
#步骤
##手工编写程序
    a 拷贝flume下面lib的包到需要收集日志的服务器
        avro-1.7.4.jar
        avro-ipc-1.7.4.jar
        commons-lang-2.5.jar
        netty-3.5.12.Final.jar
        flume-ng-core-1.6.0.jar
        flume-ng-log4jappender-1.6.0.jar
        flume-ng-sdk-1.6.0.jar
    b 配置log4j.properties
        log4j.appender.a3=org.apache.flume.clients.log4jappender.Log4jAppender
        log4j.appender.a3.Hostname = localhost
        log4j.appender.a3.Port = 44446
##利用maven组织程序
        
        <properties>
            <slf4j.version>1.7.12</slf4j.version>
            <maven.dependency.plugin.version>2.8</maven.dependency.plugin.version>
            <flume.version>1.5.2</flume.version>
        </properties>
        <dependencies>
            <dependency>
                <groupId>org.slf4j</groupId>
                <artifactId>slf4j-log4j12</artifactId>
                <version>${slf4j.version}</version>
            </dependency>
            <dependency>
                <groupId>org.apache.flume</groupId>
                <artifactId>flume-ng-core</artifactId>
                <version>${flume.version}</version>
            </dependency>
            <dependency>
                <groupId>org.apache.flume</groupId>
                <artifactId>flume-ng-sdk</artifactId>
                <version>${flume.version}</version>
            </dependency>
            <dependency>
                <groupId>org.apache.flume.flume-ng-clients</groupId>
                <artifactId>flume-ng-log4jappender</artifactId>
                <version>${flume.version}</version>
            </dependency>
        </dependencies>
        
#存在问题
* flume agent 停止运行会影响发送日志服务

#本实例注意事项
    本实例要正常运行，需要编辑 MANIFEST.MF 文件。并把依赖的flume包拷贝到lib目录

    Manifest-Version: 1.0
    Archiver-Version: Plexus Archiver
    Created-By: Apache Maven
    Built-By: sponge
    Build-Jdk: 1.7.0_71
    Main-Class: App
    Class-Path: lib/slf4j-log4j12-1.7.12.jar lib/slf4j-api-1.7.12.jar lib/log4j-1.2.17.jar lib/flume-ng-log4jappender-1.6.0.jar lib/flume-ng-log4jappender-1.6.0.jar lib/flume-ng-sdk-1.6.0.jar lib/avro-1.7.4.jar  lib/avro-ipc-1.7.4.jar lib/netty-3.5.12.Final.jar lib/commons-lang-2.5.jar
