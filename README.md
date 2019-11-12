# Java web框架

## 注解
### @Controller

类似Spring的`@Controller`

### @Service

类似Spring的`@Service`

### @Action

类似Spring的`@RequestMapping`

例: `@Actoin("get:/customer")`   

### @Inject

类似Spring的`@Autowired`

### @Aspect



### @Transaction

类似Spring的`@Transaction`

## 配置文件

src/main/resources目录下创建smart.properties文件

```properties
smart.framework.jdbc.driver=com.mysql.jdbc.Driver
smart.framework.jdbc.url=jdbc:mysql://localhost:3306/demo
smart.framework.jdbc.username=root
smart.framework.jdbc.password=root

smart.framework.app.base_package=org.smart
smart.framework.app.jsp_path=/WEB-INF/view/
smart.framework.app.asset_path=/asset/
```

## IOC

### 使用方式

需要让框架管理的类用`@Service`和`@Controller`注解

需要自动注入的变量用`@Inject`注解

## AOP

### 使用方式

实现`AspectProxy`类,并标识注解`@Aspect(Class)`[Class为需要进行aop的类]