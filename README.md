# spring-boot-basic

https://www.mygreatlearning.com/blog/spring-boot-interview-questions/


spring boot 3
spring 6

-----------
Moddel Mappers:-
https://modelmapper.org/user-manual/spring-integration/
https://mapstruct.org/documentation/installation/
---------------
SPRING BOOT:-
-------------
The main goal of spring boot is to quickly create spring based applictions without rquiring developers to write the same boilerplate configuration again and again.

Advantages:
-Spring boot starters
-Spring boot auto configuration
-Externalized Configuration
-Spring Boot  Actuator
-Easy to use embedded servlet container support

--------------
Problems with Traditional Spring app:-
-Basically spring based applications have a lot of configuration for example
  -when we develope spring MVC web application then we need to configure:
    [Component scan,Dispatcher Servlet,View resolver,Web jars(for delivering static content)] among other things.
  -When we use Hibernate/jpa in the same spring mvc app then we would need to configure:
    [Data Source,Entity manager factory/session factory, Transactional manager] among other things.  
  -When we use cache,message queue,Nosql in the same spring mvc app then we need to configure:
    [Cache configuration,Message queue configuration,NoSQL database configuration]
  -We need to maintain all integration of different jar dependencies and its compatible versions:
  
  
	
 Spring Boot Starters:-
1.These starters are pre-configured with the most commonly used library dependencies so we don't have to search for the compatible library versions and configure them manually.

2.For example the spring-boot-starter-jpa module included all the dependencies required to use spring data jpa,along with hibernate library dependencies, as hibernate is the most commonly used JPA implementation.

3.One more example,when we add the spring-boot-starter-web dependency, it will by default pull all the commonly used libraries while developing spring MVC applications, such as spring-webmvc,jackson-json,validation-api and tomcat.

4.Not only does the spring-boot-starter-web add all these libraries but it also configures the commonly registered beans like DispatcherServlet,ResourceHandlers,MessageSource,etc

Spring Boot Autoconfiguration:-
spring boot auto configuration attempts to automatically configure spring application based on the jar dependencies that we have added to project.

Example 1: If we add spring-boot-starter-web jar dependency to our spring boot app, Spring Boot assumes we are trying to build a SpringMVC-based web application and automatically tries to register spring beans such as DispatcherServlet,ViewResolver if it is not already registered.

Example 2: If we have any embeded database drivers in the classpath such as H2 or HSQL and if we haven't oconfigured a Datasource bean explecitly, then spring boot will automatically register a datasource bean using in-memory database setting.

Example 3: if we add spring-boot-starter-jpa starter dependency then it assumes that we are trying to use Hibernate to develope DAO layer so spring boot automatically register the spring beans such as Data Source,Entity Manager factory/session factory, Tradition manager. 

Spring Boot Starter parent:-
The spring-boot-starter-parent project is a special starter project that provides-
 -Default configurations
 -Manage the versions of dependencies
 -Default configurations for manven plugins
 
 @SpringBootApplication:-
 Many spring boot developers like their apps to use auto-configuration,component scan and be able to define extra configuration on their "application class".
 
 A single @SpringBootApplication annotation can be used to enable those three features that is:
 
 @EnableAutoConfiguration:enable spring boot's auto-configuration mechanism.
 @ComponentScan:enable component scan on the package where the application is located.
 @Configuration:allow to register extra beans in the context or import additional configuration classes.
 
 Note: @SpringBootConfiguration internally uses @Configuration
 
 How Spring boot works internally:-
                                                        
                                     main() method                  
                                            |
 StopWatch starts                           |                   Refresh context
 prepares environment                run() method               Trigger Runners
 Print banner
 Start the IOC container         Return ApplicationContext reference(IOC container)


 Spring Boot REST API Basics-Important Annotations:-
-@RestController->Create Simple Spring Boot REST API
-@GetMapping
-@PostMapping
-@DeleteMapping
-@PutMapping
-@PathVariable
-@RequestParam
-@RequestBody

ResponseEntity use to manipulate the HTTP response 

Java Bean Validation API overview:-
-In java the java bean validation-api has become the de-facto standard for handling validations in java projects.
 it is only specification.
 
-Hibernate Validator is the reference implementation of the validation API.

Important Bean Validation Annotations:-
-@NotNull
-@Size
-@Min
-@Max
-@Email
-@NotEmpty
-@NotBlank

Steps for Swagger:-
1.Adding springdoc-openapi Maven dependency
2.Defining genera api information(Using annotations)
3.customizing swagger api documentation with annotations
4.Customizing swagger models documentation with annotations 

Important Annotations:-
@Component:-this indicates that an annoted class is a spring bea/component.Tells spring container to automatically create spring bean.
@Autowired:-Is used to inject the bean automatically and used in constructor injection,setter injection and field injection
@Qualifier:-is used in conjuntion with @autowired to avoid confusion when we have two or more beans configured for same type.
@Primary:-to give higher preference to a bean when there are multiple beans of the same type.
@Bean:- annotation indicates that a method produces a bean to be managed by the spring container.The @Bean annotion is usually declared in cofiguration class to create spring bean definitions.
-By default, the bean name si same as method name.we can specify bean name using @Bean(name="bean name").
-it provides initMethod and destroyMethod attributes to perform certain actions after bean initialization or before bean destriction by a container.
@Lazy:-We can load the spring beans lazily(on-demand).By default spring creates all singleton beans eagerly at the startup/bootstrapping of the application context.
@Scope:- Is used to define a scope of the bean.We use @Scope to define the scope of a @Component class or a @Bean definition. The latest version of the spring framework work defines 6 types of scopes:-

-singleton:-only one instance of the bean is created and shared across the entire application.This is default.
-prototype:-a new instance of the bean is created every time it is requested.
-request
-session
-application
-websocket

The last four scopes mentioned request,session,application,websocket are only available in a web-aware application.

@Value:-used to assign default values to variables and method arguments.
-used to to get value for specific property key from the properties file.
-we can read spring environment variables as well as system variables.

ex- @Value("${user.name}")
    private String username;
    
    @Value("${java.home}")
    private String java_home
    
    @Value("${HOME}")
    private String home
    
@PropertySource:-is used to provide properties file to spring environment.
@PropertySources:-is used to provide multiple properties files to spring environment.
These annotation is used with @Configuration classes.

-Spring @PropertySource is repeatable, means we can have multiple propertysource on a configuration class.
-We can use @Value annotation and Environment class to read the property file.

@ConfProperties:- it bind external configurations to a strongly typed bean in our application code.We can inject and use this bean throughout our application code just like any other spring bean.


Stereotype annotations:-
-These annotations are used to create Spring beans automatically in the application context(spring IoC container)
-The main stereotype annotation is @Component.
-By using this annotation,Spring provides more Stereotype meta annotations such as @Service,@Respository and @Controller

-@Service:-is used to create spring beans at the service layer.
-@Repository:-is used to create spring beans for the respositories at the DAO layer
-@Controller:-is used to create spring beans at the controller layer.


========================================================================
                                ------SPRING--------:-
                                
Spring provides three types of configuration to manage the beans or object:-
1.XML based configuration
2.Annotation based configuration
3.java based configuration

Steps for java based configuration:-
----------------------------------
1.Create configuration class with @Configuration annotation
2.Create method and annotated it with @Bean annotation
3.Create Spring IOC Container(ApplicationContext) and retrive Spring bean from spring IoC container.
----------------------------------
Steps for Annotation based configuration:-

1.Annotated a class with @Component annotation
2.Use @ComponentScan annotation to specify package name for scanning those classes that are annotated with @Component annotation
3.Use @Autowired annotation to automatically inject the Spring bean
4.Use @Qualifier annotation to avoid the confusion between multiple spring beans of the same type.
5.Create Spring Ioc Container (ApplicationContext) and retrive spring bean from spring Ioc container.

@Primary Annotation:-We use @Primary annotation to give higher preference to a bean when there are multiple beans of the same type.
@Bean annotaion:-indicates that a method produces a bean to be managed by the spring container.The @Bean annotation is usually declared in configuration class to create spring bean definitions.
-by default,the bean name is same as method name.we can specify bean name using @Bean(name="beanName").
-@Bean annotation provides initMethod and destroyMethod attributes to perform certain actions after bean initialization or before bean destruction by a container.
-----------------------------------
Steps for XML based configuration:-


----------------------------------
Spring IoC Container Types:-

1.BeanFactory container:(Responsible for creating the beans, configuring the beans and managing the bean's entire life cycle.and it is basic container.

2.ApplicationContext container:-
  ->Responsible for creating the beans, configuring the beans and managing the bean's entire life cycle.
  ->Support Enterprise Application Features:-  
     ->It provides messaging functionality.
	 ->Envent publication functionality.
	 ->Annotation based dependency injection.
	 ->Easy integration with spirng AOP features.
	 ->Supports almost all types of bean scoeps.
	 
------------------------
Stereotype annotaions:-

                        @Component
                            |
                            |
          -------------------------------------------
         |                  |                       |
         |                  |                       |
         |                  |                       |
    @Controller          @Service               @Repository  
 [controller           [Service classes       [Repository Classes in DAO layer]  
  classes in            in service layer] 
  controller
  layer]  
  
 1.These annotaions are used to create spring beans automatically in the application context(ioc container).
 2.The main stereotype annotaion is @Component
 3.By using this annotaion,Spring provides more stereotype meta annotaions such as @Service,@Repository and  
   @Controller
 4.@Service annotaion is used to create spring beans at the service layer
 5.@Repository is used to create spring beans for the repositores at the DAO layer
 6.@Controller is used to create spring beans at the controller layer.
 
 ------------------------------------------------------------------------------------
Dependency Injection:-
1.Dependency injection is a design pattern on which dependency of the object is injected by the framework rather than created by Object iteself - it is also called IOC(Inversion of control).
2.Dependency injection reduces coupling between multiple objects as its dynamically injected by the framework.
3.Spring IoC container uses DI to inject one object into another object.
4.There are maninly three types of dependency injection:
    Contructor Injection,Setter Injection and Field Injection.
    
Dependency:-An object usually requires objects of other classes to perform its operations.We call these objects dependencies.
Injection:-The process of providing the required dependencies to an object.

Constructor Based Dependency Injection:-
->Constructor injection uses the contructor to inject dependency on any Spring-managed bean.
->Before Spring 4.3,we had to add an @Autowired annotation to the constructor.With newer versions,this is optional if the class only one constructor.
->When we have a class with multiple constructors, we need to explicitly add the @Autowired annotaion to any one of the constructors so that spring knows which constructor to use to inject the dependencies.

Setter Based Dependency Injection:-
->Setter injection uses the setter method to inject dependency on any spring-managed bean.
->We have to annotate the setter method with the @Autowired annotaion.
->Spring will find the @Autowired annotation and call the setter to inject the dependency.

Field Based Dependency Injection:-
->As the name says the dependency is injected dierectly in the field,with no constructor or setter needed.This is done by annotating the class member with the @Autowired annotaion.
->Spring Container uses reflection to inject the dependencies,which is costler than constructor based or setter based injection.

Field Based Dependency Injection Drawbacks:-
->We cannot create immutable dependency object,as we can with constructor injection(we can't make field final).
->Our classes have tight coupling with spring ioc container and cannot be used outside of it.
->our classes cannot be instantiated without reflection.we need the spring ioc container to instantiate them,which makes our tests more like integration tests.
->having too many dependencies is a red flag that the class usually does more than one thing,and that it may violate the single responsibility principle.
-----------------
When to use Constructor and Setter Based Dependency Injection?:-
->use constructor based DI for mandatory dependencies so that our bean is ready to use when it is first time called.
->Use setter based DI only for optional dependencies.
->Use setter injection to avoid circular dependencies.

Which one is recommended Constructor or Setter Based dependency injection:-
Spring team recommended to use constructor based dependency injection.
->All requried dependencies are available at initialization time(this reduces the code as well)
->Immutability and avoid NullPointerException
->Preventing errors in Tests.

***********************************************************************


========================================================================

SPRING BOOT:-

https://www.mygreatlearning.com/blog/spring-boot-interview-questions/

->Setting application name and server port in spring boot:
#spring.application.name=api-gateway
#server.port=8765
->Enabling profile:-
#spring.profiles.active=dev/prod/stage   
->Enabling loging level in properties file:
#logging.level.root=info
#logging.level.org.springframework=ERROR/TRACE/DEBUG/INFO/WARN  
    
->Disabling the whitelabel error page:   
#server.error.whitelabel.enabled=false

Disabling autoconfiguration:
#spring.autoconfigure.exclude=
    
->Specify the path of the OpenAPI documentation:
#springdoc.api-docs.path=/api-docs
->Specify the path of the Swagger UI:
#springdoc.swagger-ui.path=/swagger-ui.html
->Enable or disable Swagger UI:
#springdoc.swagger-ui.enabled=true 

   <dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.0.0-M4</version>
  </dependency>
 
->H2 database: 
#spring.datasource.url=jdbc:h2:mem:assetinfo  
#spring.h2.console.enabled=true
#spring.jpa.show-sql=true  

->Mysql:
#spring.datasource.url=jdbc:mysql://localhost:3306/emp
#spring.datasource.username=123
#spring.datasource.password=123
#spring.datasource.driverClassname=com.mysql.cj.jdbc.Driver
#spring.jpa.hibernate.ddl-auto=update
#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MYSQLDialect

->Oracle:
#spring.datasource.url=jdbc:oracle:thin:@t1edf1c1.ffdc.sbc.com:1524:t266edf2
#spring.datasource.username=
#spring.datasource.password=
#spring.datasource.driverClassName=oracle.jdbc.OracleDriver

->mongoDB:
#spring.data.mongodb.host=zlx72723.vci.att.com
#spring.data.mongodb.port=27017
#spring.data.mongodb.database=EDSS_ASSETINVDBO
#spring.data.mongodb.username=EDSS_ASSETINV
#spring.data.mongodb.password=EDSS_ASSETINV

->CAHCHE:
#spring.jpa.properties.hibernate.cache.use_second_level_cache=true
#spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.EhCacheRegionFactory
#spring.jpa.properties.javax.persistence.sharedCache.mode=ALL
#spring.cache.ehcache.config=classpath:echace.xml

->Cloud Config server:
#spring.cloud.config.server.git.uri=https://github.com/krvinay68/spring-application-cofig.git

->Client Config server:
#spring.cloud.config.uri=http://localhost:9999

->FOR EUREKA DSICOVERY:
#eureka.client.service-url.default-zone=http://localhost:8761/eureka

->Disabling registering eureka itself:
#eureka.client.register-with-eureka=false
#eureka.client.fetch-registry=false

->Api Gateway:
#spring.cloud.gateway.discovery.locator.enabled=true
#spring.cloud.gateway.discovery.locator.lowerCaseServiceId=true

->Resilience4j:-
#resilience4j.retry.instances.sample-api.maxRetryAttempts=5
#resilience4j.retry.instances.sample-api.maxAttempts=5
#resilience4j.retry.instances.sample-api.waitDuration=1s
#resilience4j.retry.instances.sample-api.enableExponentialBackoff=true
#resilience4j.ratelimiter.instances.default.limitForPeriod=2
#resilience4j.ratelimiter.instances.default.limitRefreshPeriod=10s
#resilience4j.bulkhead.instances.default.maxConcurrentCalls=10

Using log4j2:    
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
Using Lombok and slf4j:
     @RestController
     @Slf4j
        public class LoggingController {
            @RequestMapping("/logging")
            public String index() {
                log.trace("A TRACE Message");
                log.debug("A DEBUG Message");
                log.info("An INFO Message");
                log.warn("A WARN Message");
                log.error("An ERROR Message");
 
return "Here are your logs!”;
}
}
 
@SpringBootApplication
public class CustomApplication {
public static void main(String[] args {
SpringApplication app = new SpringApplication(CustomApplication.class);
app.setDefaultProperties(Collection.singletonMap("server.port", "8083"));
app.run(args);
}

-> get the list of all the beans in your spring boot application:
     use appContext.getBeanDefinitionNames() to get all the beans loaded by the spring container.
       By calling this method, we can show all of our beans present in our spring boot applications
       
->Docker configuration:
<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<name>progrms/demov1-${project.artifactId}:${project.version}</name>
					</image>
					<pullPlociy>IF_NOT_PRESENT</pullPlociy>
				</configuration>
			</plugin>
		</plugins>
	</build>       
    
==============================================    
