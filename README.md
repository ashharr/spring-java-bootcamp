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

# JPA and Hibernate with Spring Boot

Setting up new project for JPA and hibernate with dependencies as h2, spring web, jdbc, spring data jpa.

H2 is a relational database management system written in Java. It can be embedded in Java applications or run in client-server mode

Does NOT persist data
Great for learning
BUT NOT so great for production

### JDBC vs Spring JDBC

JDBC

JDBC

- Write a lot of SQL queries! (delete from todo where id=?)
- And write a lot of Java code

Spring JDBC

- Write a lot of SQL queries (delete from todo where id=?)
- BUT lesser Java code

JPA

- Do NOT worry about queries
- Just Map Entities to Tables!

Spring Data JPA

- Let's make JPA even more simple!

JDBC example

```java
public void deleteTodo(int id) {
PreparedStatement st = null;
try {
st = db.conn.prepareStatement("delete from todo where id=?");
st.setInt(1, id);
st.execute();
} catch (SQLException e) {
logger.fatal("Query Failed : ", e);
} finally {
if (st != null) {
try {st.close();}
catch (SQLException e) {}
}
}
}
```

Spring JDBC example

```java
public void deleteTodo(int id) {
jdbcTemplate.update("delete from todo where id=?", id);
}
```

## Spring Boot App using a. Spring JDBC

Creating a simple course POJO, repository and command line runner class to run queries to H2 db.

![Course POJO](assets/carbon_(13)%201.png)

Course POJO

![JDBC Repository using JdbcTemplate](assets/carbon_(15)%201.png)

JDBC Repository using JdbcTemplate

![Command Line Runner file](assets/carbon_(16)%201.png)

Command Line Runner file

## b. Using JPA to do the above

Using Entity annotation to map the Course POJO to the Database.

@Entity will do the mapping for us

@EntityManager is used to perform operations on the entity

![POJO](assets/carbon_(17)%201.png)

POJO

![JPA Repo](assets/carbon_(18)%201.png)

JPA Repo

![Command Line Runner](assets/carbon_(19).png)

Command Line Runner

## c. Using Spring Data JPA

Spring Data JPA makes things even more easier by pushing the entity manager to the background

It should also enables us to use many more functions built in 

Just create a new interface extending the Jpa Repository with the Entity generic

for updates/inserts use save funtion.

![interface](assets/carbon_(20).png)

interface

![making use of the new repository which has Spring Data enabled in Command Line Runner](assets/carbon_(21).png)

making use of the new repository which has Spring Data enabled in Command Line Runner

You can even add your own functions and Spring data will create it

```java
package com.springbootcamp.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootcamp.springboot.learnjpaandhibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
	
	
		List<Course> findByAuthor(String author);
	
		List<Course> findByName(String name);
}
```

```java
package com.springbootcamp.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springbootcamp.springboot.learnjpaandhibernate.course.Course;
import com.springbootcamp.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.springbootcamp.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{
	
//	@Autowired
//	private  CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1,"Learn AWS", "Ashhar"));
		repository.save(new Course(2,"Zero to hero in Python", "Bonny"));
		repository.save(new Course(3,"Full Stack React", "Faraz"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		**System.out.println(repository.findByAuthor("Faraz"));
		System.out.println(repository.findByName("Zero to hero in Python"));**
		
	}

}
```

# Creating a Full To Do Web App using Spring Framework, Spring Boot and Hibernate

## Dependencies –

## Creating Controller that responds back with “Hello”

1. String Response –
    
    @ResponseBody indicates a method return value should be bound to the webresponse body.
    
    ```java
    @RequestMapping("say-hello")
    	@ResponseBody
    	public String sayHello() {
    		return "Hello! What are you learning today?";
    	}
    ```
    
2. HTML Response using String Builder/Buffer –

```java
@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML Page - Changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>My first html page with body</h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
```

1. JSP Response –
    
    Here we remove Response Body because we return a JSP file that is in the location where spring directory stores the JSP files – “**/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp**”
    
    We need to add in [application.properties](http://application.properties) so that spring knows we have a JSP here
    
    ```java
    spring.mvc.view.prefix=/WEB-INF/jsp/
    spring.mvc.view.suffix=.jsp
    ```
    
    sayHello.jsp content
    
    ```java
    <html>
    	<head>
    		<title> My first HTML Page - JSP</title>
    	</head>
    	<body>
    		My first html page with body - JSP
    	</body>
    </html>
    ```
    

SayHelloController for reference –

```java
package com.mytodoapp.springboot.mytodoapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloControlller {
	
	//TODO: Build a controller method that returns "Hello! What are you learning today?" as the response body
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML Page - Changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>My first html page with body</h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}
```

## Login Controller with @RequestParams

login.jsp

```java
<html>
	<head>
		<title> Login Page</title>
	</head>
	<body>
		Welcome to the login page ${name}! 
	</body>
</html>
```

LoginController

```java
package com.mytodoapp.springboot.mytodoapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp
	@RequestMapping("login")
	String loginPage(@RequestParam String name, ModelMap model) {
		System.out.println("Login Controller – RequestParam: name = "+name);
		model.put("name", name);
		return "login";
	}
}
```

## Modern Spring Boot Application Architecture

![Untitled](assets/Untitled%203.png)

A: Receives HTTP Request

B: Processes HTTP Request

B1: Identifies correct Controller method /login => LoginController.gotoLoginPage

B2: Executes Controller method => Puts data into model => Returns view name => login

B3: Identifies correct View /WEB-INF/jsp/login.jsp

B4: Executes view

C: Returns HTTP Response

Adding the JSTL dependency –

```html
	<dependency>
			<groupId>jakarta.servlet.jsp.jstl</groupId>
			<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
		</dependency>

		<dependency>
			<groupId>org.eclipse.jetty</groupId>
			<artifactId>glassfish-jstl</artifactId>
		</dependency>
```

## Basic Authentication

We add basic authenticationService to validate the username and password.

```java
package com.mytodoapp.springboot.mytodoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService{
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUsername = username.equalsIgnoreCase("ashhar");
		boolean isValidPassword = password.equalsIgnoreCase("spring");
		
		return isValidUsername && isValidPassword;
	}
}
```

Now we can make use of it in the login controller –

```java
package com.mytodoapp.springboot.mytodoapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp
	
	private AuthenticationService authenticationService;
	
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login",  method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="login",  method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			return "welcome";
		}

		model.put("loginError", "Error: Invalid username/password!");
		return "login";
	}
}
```

If the user is authenticated correctly it will forward the user to the welcome page, otherwise it will redirect back to login page and show an error.

## Todo Controller and Service

Now to add the todo list functionality we will add a controller and service for it.

Todo.java

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.time.LocalDate;

public class Todo {
	private int id;
	private String username;
	private String description;
	private LocalDate targetDate;
	private boolean done;

	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

}
```

TodoController.java

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todos) {
		super();
		this.todoService = todos;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("ashhar");
		model.addAttribute("todos", todos);
		return "listTodos";
	}
}
```

TodoService.java

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();

	static {
		todos.add(new Todo(1, "Ashhar", "Learn Azure Devops", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(2, "Anas", "Learn SQL", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(3, "Faraz", "Learn Business Development", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(4, "Masood", "Learn Django", 
				LocalDate.now().plusWeeks(20), false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}

}
```

and the page that shows the list of all the todos, also for now we have just added static list of todos in the form of a table to show temporary data. 

**@SessionAttributes(”name”)** is the annotation we use on the Login Controller and the TodoController to broaden the scope.

listTodos.jsp

```html
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title> Todos</title>
	</head>
	<body>
		<div>Welcome to Todo App, ${name} !</div>
		<br><div>
			<h1>Your Todos</h1>
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</body>
</html>
```

## Request vs. Session Scope

All requests from browser are handled by our web application deployed on a server
**Request Scope:** 

Active for a single request ONLY
Once the response is sent back, the request attributes
will be removed from memory
These cannot be used for future requests
Recommended for most use cases

**Session Scope:** 

Details stored across multiple requests
Be careful about what you store in session (Takes
additional memory as all details are stored on server)

We will make “name” which has Request scope to have session scope so it is available on the list-todos page as well.

**@SessionAttributes(”name”)** is the annotation we use on the Login Controller and the TodoController to broaden the scope.

![Untitled](assets/Untitled%204.png)

## Adding Bootstrap and JQuery to improve look and Feel

1) Adding in POM.xml

```html
<dependency>
	<groupId>org.webjars</groupId>
	<artifactId>bootstrap</artifactId>
	<version>5.1.3</version>
</dependency>

<dependency>
	<groupId>org.webjars</groupId>
	<artifactId>jquery</artifactId>
	<version>3.6.0</version>
</dependency>
```

2) Adding in the JSP Files

```html
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
```

Now we can add classes like “container” for entier div body and “table” class for the HTML table to get a better UI.

Further we will improve it later.

## Add a Todo page to add new Todo and Enter Details

Adding a Add Todo Button in List Todos Page

```html
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
	<head>
	<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel ="stylesheet">
		<title> Todos</title>
	</head>
	<body>
		<div class ="container">
			<h1>Your Todos</h1>
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			**<a href="add-todo" class="btn btn-success">Add Todo</a>**
		</div>
		<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
	</body>
</html>
```

TodoController.java

```java
@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String addTodosPage() {
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String listTodosPageRedirectFromAddPage(@RequestParam String description, ModelMap model) {
		// we cant return listTodos because the old page is not being shown since its empty
		// we gotta make use of redirect to show the same page
		// we have to fetch the username from model and also cast it to String because it is of a different type
		String username = (String) model.get("name");
		todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
```

todo.jsp

```java
<%--/META-INF/resources/webjars/bootstrap/5.2.3/js/bootstrap.min.js
/META-INF/resources/webjars/bootstrap/5.2.3/css/bootstrap.min.css
/META-INF/resources/webjars/jquery/3.6.4/jquery.min.js--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
	<head>
	<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel ="stylesheet">
		<title> Todos</title>
	</head>
	<body>
		<div class ="container">
			<h1>Enter Todo Details:</h1>
			<form method="post">
				Description: <input type="text" name="description">
				<input type="submit" class="btn btn-success">
			</form>
		</div>
		<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
	</body>
</html>
```

Adding that object to the Todo List page

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static int todoCount = 0;

	private static List<Todo> todos = new ArrayList<>();

	static {
		todos.add(new Todo(++todoCount, "Ashhar", "Learn Azure Devops", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(++todoCount, "Anas", "Learn SQL", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(++todoCount, "Faraz", "Learn Business Development", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(++todoCount, "Masood", "Learn Django", 
				LocalDate.now().plusWeeks(20), false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate date, boolean done) {
		Todo todo = new Todo(++todoCount, username, description, date, done);
		todos.add(todo);
	}
	
}
```

## Adding Validations to the input fields using Spring Boot Starter Validation

Lets add validation for the description field such that we cannot enter less than 10 characters

[Todo.java](http://Todo.java) POJO

```java
@Size(min = 10, message = "Enter atleast 10 characters.")
	private String description;
```

If you ctrl click Size and select Link with editor button you can see a list of all the validations you can add.

![Untitled](assets/Untitled%205.png)

Adding validation dependency for Spring boot n pom.xml

```html
<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

Making it Description field as required and adding form:errors tag

todo.jsp

```html
<form:input type="text" path="description" required="required"/>
<form:errors path="description" cssClass="text-warning"/>
```

Adding BindingResult to the method to check for errors AND @Valid todo annotation for our Todo POJO

BindingResult – General interface that represents binding results. Extends the  `Errors` interface for error registration capabilities, allowing for a `Validator` to be applied, and adds binding-specific analysis and model building.

TodoController.java

```java
@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String listTodosPageRedirectFromAddPage(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		// we cant return listTodos because the old page is not being shown since its empty
		// we gotta make use of redirect to show the same page
		
		// we have to fetch the username from model and also cast it to String because it is of a different type
		String username = (String) model.get("name");
		
		
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
```

![Untitled](assets/Untitled%206.png)

## Delete and Update Todo Features

Adding Delete And Update Buttons in listTodos.jsp

```html
<%--/META-INF/resources/webjars/bootstrap/5.2.3/js/bootstrap.min.js
/META-INF/resources/webjars/bootstrap/5.2.3/css/bootstrap.min.css
/META-INF/resources/webjars/jquery/3.6.4/jquery.min.js--%>
<%@ include file="common/navbar.jspf" %>
<%@ include file="common/header.jspf" %>

		<div class ="container">
			<h1>Your Todos</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td> <a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
							<td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>		
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
<%@ include file="common/footer.jspf" %>
```

Creating GET and POST methods that handle the action for update/delete

Note: We make use of the same todo.jsp page for updating the todo.

```java
@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updateTodos(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.updateTodos(todo);
		return "redirect:list-todos";
	}
```

Methods in TodoService

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static int todoCount = 0;

	private static List<Todo> todos = new ArrayList<>();

	static {
		todos.add(new Todo(++todoCount, "Ashhar", "Learn Azure Devops", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(++todoCount, "Anas", "Learn SQL", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(++todoCount, "Faraz", "Learn Business Development", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(++todoCount, "Masood", "Learn Django", 
				LocalDate.now().plusWeeks(20), false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate date, boolean done) {
		Todo todo = new Todo(++todoCount, username, description, date, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate =
				todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate =
				todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodos(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
	}
	
}
```

![Untitled](assets/Untitled%207.png)

![Untitled](assets/Untitled%208.png)

## Adding TargetDate field in the Details page and formatting it using bootstrap-datepicker

![Untitled](assets/Untitled%209.png)

Bootstrap DatePicker Dependency

```html
<dependency>
		    <groupId>org.webjars</groupId>
		    <artifactId>bootstrap-datepicker</artifactId>
		    <version>1.9.0</version>
		</dependency>
```

TargetDate Field doesnt exist in the form yet. lets add it in –

```html
<%--/META-INF/resources/webjars/bootstrap/5.2.3/js/bootstrap.min.js
/META-INF/resources/webjars/bootstrap/5.2.3/css/bootstrap.min.css
/META-INF/resources/webjars/jquery/3.6.4/jquery.min.js--%>
<%@ include file="common/navbar.jspf" %>
<%@ include file="common/header.jspf" %>
		
		<div class ="container">
			
			<h1>Enter Todo Details:</h1>
			
			<form:form method="post" modelAttribute="todo">
			
				<fieldset class="mb-3">
					<form:label path="description">Description</form:label>	
					<form:input type="text" path="description" required="required"/>
					<form:errors path="description" cssClass="text-warning"/>
				</fieldset>
				
				<fieldset class="mb-3">
					<form:label path="targetDate">Target Date</form:label>	
					<form:input type="text" path="targetDate" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning"/>
				</fieldset>
				
				<form:input type="hidden" path="id" required="required"/>
				<form:input type="hidden" path="done" required="required"/>
				<input type="submit" class="btn btn-success">
			</form:form>
		</div>
	
<%@include file="common/footer.jspf" %>
	<script type="text/javascript">
				$('#targetDate').datepicker({
				    format: 'yyyy-mm-dd',
				});
	</script>
```

We have taken the common tags and included them in the header.jspf and footer.jspf in “common” folder. In the header and footer we including the css and js files for date picker 

footer.jspf

```html
<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
		<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		
	</body>
</html>
```

header.jspf

```html
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
	<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel ="stylesheet">
	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css" rel ="stylesheet">
		<title> Todos</title>
	</head>
	<body>
```

Navbar is also added but it isnt functional as of now

navbar.jspf

```html
<nav class="navbar navbar-expand-md navbar-light mb-3 p-1 border-bottom" style="background-color: #e3f2fd;">
	<a class="navbar-brand m-1" href="https://courses.in28minutes.com">To-Do App</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>	
</nav>
```

Add this navbar to the listTodos.jsp, welcome.jsp and todo.jsp

# Adding our own Login Setup using Spring Security

## Changing LoginController to WelcomeController

The home tab will return to welcome.jsp page → “/”

WelcomeController.java

```java
package com.mytodoapp.springboot.mytodoapp.login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp
	

	@RequestMapping(value="/",  method=RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUsername());
		return "welcome";
	}
	
	
	private String getLoggedInUsername() {
		Authentication authentication = 
		SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
}
```

## Adding Spring Security dependency

```html
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
```

## Configuring Spring Security with Custom User and Password Encoder

Creating SecurityConfiguration.java

We will use in memory data to configure and authenticate users

```java
package com.mytodoapp.springboot.mytodoapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	// Typically in PROD application we make use of LDAP or Database
	// Here we make use of In memory database
	//	InMemoryUserDetailsManager -> Password Encoder -> UserDetails
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails1 = createNewUser("Ashhar", "24565134");
		UserDetails userDetails2 = createNewUser("admin", "dummy");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		// lambda function to create the password encoder
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = 	User.builder()
										.passwordEncoder(passwordEncoder)
										.username(username)
										.password(password)
										.roles("USER","ADMIN")
										.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
```

Now in Welcome Controller we will make use of the authenticated username by craeting a getLoggedInUsername

WelcomeController.java

```java
package com.mytodoapp.springboot.mytodoapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp
	

	@RequestMapping(value="/",  method=RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUsername());
		return "welcome";
	}
	
	
	private String getLoggedInUsername() {
		Authentication authentication = 
		SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
```

We will also make use of the getLoggedInusername Function instead of model.get

We do this to remove hardcoded User Name and making use of Authenticated user by SecurityContextHolder

TodoController.java

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todos) {
		super();
		this.todoService = todos;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoService.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
		SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String addTodosPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String listTodosPageRedirectFromAddPage(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		// we cant return listTodos because the old page is not being shown since its empty
		// we gotta make use of redirect to show the same page
		
		// we have to fetch the username from model and also cast it to String because it is of a different type
		String username = getLoggedInUsername(model);
		
		
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updateTodos(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.updateTodos(todo);
		return "redirect:list-todos";
	}
}
```

Updating findByUsername method in TodoService 

TodoService.java

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static int todoCount = 0;

	private static List<Todo> todos = new ArrayList<>();

	static {
		todos.add(new Todo(++todoCount, "Ashhar", "Learn Azure Devops", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(++todoCount, "Anas", "Learn SQL", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(++todoCount, "Faraz", "Learn Business Development", 
				LocalDate.now().plusWeeks(20), false));
		todos.add(new Todo(++todoCount, "Masood", "Learn Django", 
				LocalDate.now().plusWeeks(20), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate =
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate date, boolean done) {
		Todo todo = new Todo(++todoCount, username, description, date, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate =
				todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate =
				todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodos(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
	}
	
}
```

## Configuring Spring Security for H2 Database connection

Adding the dependencies for database connection

```html
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<scope>runtime</scope>
</dependency>
```

application.properties

`spring.datasource.url=jdbc:h2:mem:testdb`
****

Changing security config to allow h2 database url 

1. disabling CSRF
2. enabling frames

SecurityConfig.java in security package

```java

package com.in28minutes.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	//All URLs are protected
	//A login form is shown for unauthorized requests
	//CSRF disable
	//Frames
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
	}
}
```

// Now H2 DB is enabled

![Untitled](assets/Untitled%2010.png)

## Making Todo Entity Table in H2 and inserting data using data.sql

@Entity for Todo POJO for JPA database access and lets JPA knows this class is entity of JPA

@Id and @GeneratedValue are annotations for the ID key

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	
	public Todo() {
		
	}

	@Id
	@GeneratedValue
	private int id;
	
	private String username;

	@Size(min = 10, message = "Enter atleast 10 characters.")
	private String description;

	private LocalDate targetDate;
	private boolean done;

	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

}
```

## Instead of static data now making use of JPA repository to show H2 Database table data

TodoRepository.java

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	public List<Todo> findByUsername(String username);
}
```

application.properties

`spring.jpa.defer-datasource-initialization=true`
****

data.sql

```sql
insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10001,'Ashhar', 'Get AWS Certified', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10002,'Ashhar', 'Get Azure Certified', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10003,'Ashhar', 'Get GCP Certified', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10004,'Ashhar', 'Learn DevOps', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10005,'admin', 'Full Stack Engineer Course', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10006,'admin', 'Java Developer Certification Course', CURRENT_DATE(), false);
```

![Untitled](assets/Untitled%2011.png)

## Implementing all methods of TodoService for TodoRepository

Copy old todo controller and now instead of the todoService we will make use of the TodoRepository to interact with the DB instead of the Static data that was used earlier.

.save() for create and update

.deleteById() for deleting one entity by ID

.findById() to get one entity by ID

There are many more other function which the JPA repository provides…

TodoControllerJpa.java

```java
package com.mytodoapp.springboot.mytodoapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	private TodoService todoService;

	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		//List<Todo> todos = todoService.findByUsername(username);   // static data
		
		//Now making use of TodoRepo instead of static data from service to show list
		List<Todo> todos = todoRepository.findByUsername(username);
		
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
		SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String addTodosPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String listTodosPageRedirectFromAddPage(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		// we cant return listTodos because the old page is not being shown since its empty
		// we gotta make use of redirect to show the same page
		
		// we have to fetch the username from model and also cast it to String because it is of a different type
		String username = getLoggedInUsername(model);
		
		
		//todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		todo.setUsername(username);
		todoRepository.save(todo);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//todoService.deleteById(id);
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		//Todo todo = todoService.findById(id);
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updateTodos(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		//todoService.updateTodos(todo);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
}
```

# Connecting to MySQL database using Docker container

Download Docker and run this command

*docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3360:3306 mysql:8-oracle*

dependency in POM.xml

```html
<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.33</version>
	</dependency>
```

Download MySQL-sh

application.properties

*spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3360/todos
spring.datasource.username=todos-user
spring.datasource.password=dummytodos
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect*

*#\connect Ashhar@localhost:3306*

MySQL-sh

```html
MySQL  JS > \connect todos-user@localhost:3360
Creating a session to 'todos-user@localhost:3360'
Please provide the password for 'todos-user@localhost:3360': **********
Save password for 'todos-user@localhost:3360'? [Y]es/[N]o/Ne[v]er (default No): y
Fetching schema names for auto-completion... Press ^C to stop.
Your MySQL connection id is 9
Server version: 8.0.33 MySQL Community Server - GPL
No default schema selected; type \use <schema> to set one.
 MySQL  localhost:3360 ssl  JS > \use todos
Default schema set to `todos`.
 MySQL  localhost:3360 ssl  todos  JS > \sql
Switching to SQL mode... Commands end with ;
Fetching global names, object names from `todos` for auto-completion... Press ^C to stop.
Error during auto-completion cache update: Access denied; you need (at least one of) the PROCESS privilege(s) for this operation
 MySQL  localhost:3360 ssl  todos  SQL > select * from todo
                                      -> ;
Empty set (0.0021 sec)
 MySQL  localhost:3360 ssl  todos  SQL > select * fromm todo;
ERROR: 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'fromm todo' at line 1
 MySQL  localhost:3360 ssl  todos  SQL > select * from todo;
Empty set (0.0012 sec)
 MySQL  localhost:3360 ssl  todos  SQL > select * from todo;
+----+------------------------+------+-------------+----------+
| id | description            | done | target_date | username |
+----+------------------------+------+-------------+----------+
|  1 | Learn Data Science New | 0x00 | 2024-06-06  | Ashhar   |
+----+------------------------+------+-------------+----------+
1 row in set (0.0019 sec)
 MySQL  localhost:3360 ssl  todos  SQL > ls
                                      -> ;
ERROR: 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'ls' at line 1
 MySQL  localhost:3360 ssl  todos  SQL > select * from todo;
```

Now Spring App is connected to MySQL DB

END OF SECTION