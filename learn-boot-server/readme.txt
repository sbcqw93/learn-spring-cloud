1、SpringBootWebServer使用Boot内嵌容器启动微服务

2、使用第三方容器
    1、pom
    <packaging>war</packaging>
    2、pom
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
    3、新建SpringBootWebServerThird类，继承SpringBootServletInitializer并重写configure