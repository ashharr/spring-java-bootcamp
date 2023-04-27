# Spring Framework Notes

![Untitled](assets/Untitled.png)

Go to [start.spring.io](http://start.spring.io) and download your spring boilerplate application.

We are going to design game runner app that runs 3 games (classes)

1. SuperContra
2. MarioGame
3. PacmanGame

Before using spring framework lets make use of Java to build and run these classes

Add the  AppGamingBasicJava which will run the game classes

![carbon (4).png](assets/carbon_(4).png)

Add the GameRunner Class in game package

![carbon (7).png](assets/carbon_(7).png)

Add the game classes in the game package

eg MarioGame

![carbon (6).png](assets/carbon_(6).png)

Now you can see the game classes are tightly coupled if want to run another game 

We will have to make changes to the GameRunner Class and add another constructor to it

Coupling is important in Software Development

We can make this tight couple behavior to loosely coupled by adding an interface for the three game classes

These classes will implement this interface and we will use this interface in the GameRunner class

To avoid code changes when we wanna run a different game class

Let’s call this interface GamingConsole

[https://www.notion.so](https://www.notion.so)

Also, add it to the GameRunner class

![carbon (9).png](assets/carbon_(9).png)

So this is how we would build an App in Java. 

Here you can see we ourselves did the Coding, Wiring and you can say even configuration.

The number of lines of code and time taken is higher. How can we reduce this?

## Spring Framework

Let’s see how spring framework can help us in doing this faster…

 Add another class in main package HelloWorldSpring.java

![carbon (10).png](assets/carbon_(10).png)

We Need to build another class called HelloWorldConfiguration which will have the Spring annotatoin @Configuration

![carbon (11).png](assets/carbon_(11).png)

Every Configuration class in Spring has Bean Methods

@Configuration just indicates that the class has bean methods. So Spring container can process the class and generate Spring Beans to be used in the application.

@Bean annotation indicates that a method produces a bean to be managed by the Spring container. Bean is object that is managed by Spring. 

Application Context is used to load Bean definitions 

Eg. **var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);**

We can makek use of this object to load beans: 

**context.getBean("address2")** // we pass the bean method name

![Untitled](assets/Untitled%201.png)

## Applying Spring Concepts to Build GameRunner app

Add the application context class which will get the beans

[App03AppGamingSpringBeans.java](http://App03AppGamingSpringBeans.java) 

![carbon (12).png](assets/carbon_(12).png)

GamingConfiguration is the config file for our app which will contain the Spring beans

![carbon (13).png](assets/carbon_(13).png)

Context is in try-with block so that java will close the context for us. This will avoid any leaks.

Our Spring App is ready. Now Spring is managing the Data for us and autowiring it. 🙂

## Spring @Component Annotation, Dependency Injection

@Component is an instance of a class which will be managed by Spring frammework

Autowiring of component is done in three ways

1) Field based injection

2) Setter based injection

3) Constructor based injection ( RECOMMMENDED by Spring team)

![carbon (14).png](assets/carbon_(14).png)

For example now lets build a Spring application for the below purpose

![Untitled](assets/Untitled%202.png)

DataService Interface

![carbon (15).png](assets/carbon_(15).png)

MongoDBDataService & MySQLDataService implements DataService

![carbon (16).png](assets/carbon_(16).png)

BusinessCalculationService class

![carbon (17).png](assets/carbon_(17).png)

Spring Config File

![carbon (18).png](assets/carbon_(18).png)

Result: 55

Spring Framework manages the **lifecycle** of objects:

INSTEAD of FOCUSING on objects, their dependencies and wiring
You can focus on the business logic of your application!

1. Mark components using annotations: ***@Component*** (and others..)
2. Mark dependencies using ***@Autowired***

3. If there are many components and you want to use 1 make use of ***@Primary***

4. If there are many components and you want to use as per name use ***@Qualifier***

## Exploring Lazy and Eager Initialization of Spring Framework Beans

Default Initialization is Eager Initialization.

For Lazy Initialization we make use of @Lazy Annotation

This will make the bean be initialized when it is first made use of in the application.

However Lazy Initialization is  NOT recommended and NOT frequently used.

Eager Initialization which is the default one makes the bean Initialize at startup of the application

So if there are any spring confiuration error we come to know at startup

On the contrary for Lazy init config errors become runtime errors. That’s why Eager is preferred.

![carbon (1).png](assets/carbon_(1).png)

## Spring Bean Scopes

Spring beans are defined to be used in a specific Scope::

1. Singleton:  One Object per spring container. (Default or @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON))
2. Prototype: Possibly many object instances per Spring IoC container.(@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE))

Scopes are applicable ONLY for web-aware Spring ApplicationContext

- Request -prototype
- Session -prototype
- Applicaton -prototype
- Websocket -prototype

Java Singleton (GOF) vs Spring Singleton

— Spring singleton: One object per spring IoC container.

—  Java Singleon: One object instance per JVM.

![carbon (3).png](assets/carbon_(3).png)

## Post Construct and Pre Destroy Annotations

@PostConstruct – The `PostConstruct` annotation is used on a method that  needs to be executed after dependency injection is done to perform  any initialization. This  method must be invoked before the class  is put into service.

@PreDestroy – The `PreDestroy` annotation is used on a method as a callback notification to signal that the instance is in the process of being removed by the container. The method annotated with `PreDestroy` is typically used to release resources that it has been holding.

![carbon (4).png](assets/carbon_(4)%201.png)

## Jakarta CDI with Spring Framework and Java

@Named is @Component

@Inject is @Autowired

In the below example we make use of Setter based dependency injection.

First add the dependency of Jakarta in pom.xml

```xml
<dependency>
			<groupId>jakarta.inject</groupId>
			<artifactId>jakarta.inject-api</artifactId>
			<version>2.0.1</version>
		</dependency>
```

![carbon (5).png](assets/carbon_(5).png)

## Java Spring XML Configuration

This is an older way of configuring Spring Application. It was used a lot earlier

Later on, Spring Annotations were introduced.

![xml context file](assets/carbon_(6)%201.png)

xml context file

![contextConfiguration.xml](assets/carbon_(7)%201.png)

contextConfiguration.xml

## Spring Framework Stereotype Annotations - Component and more

@Component - Generic annotation applicable for any class
Base for all Spring Stereotype Annotations
Specializations of @Component:

@Service - Indicates that an annotated class has business logic
@Controller - Indicates that an annotated class is a "Controller" (e.g. a web controller)
Used to define controllers in your web applications and REST API
@Repository - Indicates that an annotated class is used to retrieve and/or manipulate
data in a database

# Getting Started With Spring Boot

World before spring boot:

- Setting up projects wasnt easy
- A lot of configuration
- POM.xml
- Manage frameworks and versions (dependency management)
- Defining Spring configurations
    - componentscan
    - viewresolver
- Loggin, Error Handling and Monitoring (full implementation)
- And repeating all this for every new project. (few days to setup and config)

## Creating a Simple Spring Boot Project

Spring Boot provides auto configuration

Spring Boot (NOT Spring MVC) provides non functional requirements (NFRs) - Actuator and Embedded Server, Profiles and ConfigurationProperties.

@SpringBootApplication annotation is a combination of 3 annotations: @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan

Code:

![carbon (9).png](assets/carbon_(9)%201.png)

![carbon (10).png](assets/carbon_(10)%201.png)

![carbon (12).png](assets/carbon_(12)%201.png)

you can also create a jar file using maven build → clean install

run as → java -jar <JAR file> 

## Spring boot auto-configuration

Spring Boot auto-configuration **attempts to automatically configure your Spring application based on the jar dependencies that you have added**. 

For example, if HSQLDB is on your classpath, and you have not manually configured any database connection beans, then Spring Boot auto-configures an in-memory database.

Change log levels in [application.properties](http://application.properties) to get the better understanding of how auto-confi works: logging.level.org.springframework=debug

## Spring Boot Actuator endpoints

Add spring-starter-actuator dependency to pom.xml

```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

It helps in monitoring and managing the application

to do this it provides various endpoints:

- metrics
- health
- beans
- mappings… and so on

## Spring Core VS. Spring MVC VS. Spring Boot

1. Spring Framework: Dependency Injection
@Component, @Autowired, Component Scan etc..
Just Dependency Injection is NOT sufficient (You need other frameworks to build apps)
Spring Modules and Spring Projects: Extend Spring Eco System
Provide good integration with other frameworks (Hibernate/JPA, JUnit & Mockito for Unit Testing)

2. Spring MVC (Spring Module): Simplify building web apps and REST API
Building web applications with Struts was very complex
@Controller, @RestController, @RequestMapping("/courses")

3. Spring Boot (Spring Project): Build PRODUCTION-READY apps QUICKLY
Starter Projects - Make it easy to build variety of applications
Auto configuration - Eliminate configuration to setup Spring, Spring MVC and other frameworks!
Enable non functional requirements (NFRs):
Actuator: Enables Advanced Monitoring of applications
Embedded Server: No need for separate application servers!
Logging and Error Handling
Profiles and ConfigurationProperties

Advantages: Get started quickly with production ready features!