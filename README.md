# springboot
整合JPA，SHIRO, websocket等等

### spring-boot-common
属于异常的统一处理，及请求响应体的统一封装
封装了成功请求的success和失败请求的fail以及异常的exception

### spring-boot-jpa
从入门的直接使用jpaentitymanager，到自定义sql语句，再到封装Specification
对象来进行根据条件筛选查询，并分页处理

### spring-boot-websocket
实现了客户端与服务端的异步双工交互逻辑，实现服务端的广播式推送以及点对点式推送


### spring-boot-async
springboot 的@Async异步实现
栗子有：同步处理、异步处理、异步处理加回调

### spring-boot-shiro
```xml
<dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-spring-boot-web-starter</artifactId>
    <version>1.4.1</version>
</dependency>
```
依赖上述优雅的整合方式，实现shiro与springboot的结合。
其中shiro可以通过简单配置实现网站的登陆认证，
也可通过复杂配置，根据用户的角色进行分配权限，
以及根据不同的权限访问不同的url，甚至相同的url不同的请求方法的权限验证，
或者使用@RequiredRoles注解实现不同角色访问方法的控制

### spring-cloud
使用了eureka，feign，Ribbon，hystrix，gateway，还有config和bus组件未使用，在模块的readme文件中有配置详情