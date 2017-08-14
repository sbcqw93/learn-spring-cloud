# learn-spring-cloud

### Spring config 例子
>     learn-config-server
>     learn-config-client
github配置文件 [[config-repo]](https://github.com/sbcqw93/learn-spring-config-repo)

### Spring eureka 例子
启动两个eureka服务(高可用)
>     "D:\Program Files\Java\jdk1.8.0_131\bin\java" -jar target\learn-eureka-server.jar --spring.profiles.active=peer1
>     "D:\Program Files\Java\jdk1.8.0_131\bin\java" -jar target\learn-eureka-server.jar --spring.profiles.active=peer2

启动几个eureka客户端
>     "D:\Program Files\Java\jdk1.8.0_131\bin\java" -jar target\learn-eureka-client.jar --spring.profiles.active=subject
>     "D:\Program Files\Java\jdk1.8.0_131\bin\java" -jar target\learn-eureka-client.jar --spring.profiles.active=verb
>     "D:\Program Files\Java\jdk1.8.0_131\bin\java" -jar target\learn-eureka-client.jar --spring.profiles.active=adjective
>     "D:\Program Files\Java\jdk1.8.0_131\bin\java" -jar target\learn-eureka-client.jar --spring.profiles.active=noun
