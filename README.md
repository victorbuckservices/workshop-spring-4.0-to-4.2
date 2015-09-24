# Workshop - From Spring 4.0 To 4.2

This workshop implements an example of most Spring Framework features from the 4.0 to 4.2 releases.

## How to use ?

Run the Spring Boot Application application

```bash
#> mvn spring-boot:run
```

Associated to each feature, there is an integration test or a web page.

Note: Tests should be launched with your IDE in debug mode to understand what happens step by step.

## Spring 4.0


##### Groovy Bean Definition DSL [[1]](src/main/java/demo/_40/groovybean) [[2]](src/test/java/demo/_40/groovybean)

> Beginning with Spring Framework 4.0, it is possible to define external bean configuration using a Groovy DSL. This is similar in concept to using XML bean definitions but allows for a more concise syntax. Using Groovy also allows you to easily embed bean definitions directly in your bootstrap code.

* XML on steroid
* May be used to create beans using logic (conditional)
* May be used to dynamicaly create beans (iteration)
* Can be loaded at runtime

##### Generic types as a form of qualifier [[1]](src/main/java/demo/_40/generic) [[2]](src/test/java/demo/_40/generic)

> Spring now treats generic types as a form of qualifier when injecting Beans. For example, if you are using a Spring Data Repository you can now easily inject a specific implementation: @Autowired Repository<Customer> customerRepository.


##### Meta-annotation support [[1]](src/main/java/demo/_40/metaannotation)

> If you use Spring’s meta-annotation support, you can now develop custom annotations that expose specific attributes from the source annotation.

See next feature for the example.


##### The @Lazy annotation can now be used on injection points [[1]](src/main/java/demo/_40/lazy) [[2]](src/test/java/demo/_40/lazy)
Lazy bean, initialized only when needed and if used.

##### Beans can now be ordered when they are autowired into lists and arrays [[1]](src/main/java/demo/_40/ordered) [[2]](src/test/java/demo/_40/ordered)

> Beans can now be ordered when they are autowired into lists and arrays. Both the @Order annotation and Ordered interface are supported.

May be useful for listener.

##### Conditionally filtering beans [[1]](src/main/java/demo/_40/conditional) [[2]](src/test/java/demo/_40/conditional)

> A generalized model for conditionally filtering beans has been added via the @Conditional annotation. This is similar to @Profile support but allows for user-defined strategies to be developed programmatically.

##### @RestController annotation with Spring MVC applications [[1]](src/main/java/demo/_40/rest)

> You can use the new @RestController annotation with Spring MVC applications, removing the need to add @ResponseBody to each of your @RequestMapping methods.

Meta annotation of @Controller @ResponseBody. Rest semantics.

##### AsyncRestTemplate allows non-blocking asynchronous REST clients. [[1]](test/main/java/demo/_40/async)

> The AsyncRestTemplate class has been added, allowing non-blocking asynchronous support when developing REST clients.

Supported HTTP provider: Netty, OkHttp, HttpComponents, JDK


## Spring 4.1

##### Caching Improvements, JCache (JSR-107) annotations [[1]](src/main/java/demo/_41/cache) [[2]](test/main/java/demo/_41/cache)

> Spring 4.1 supports JCache (JSR-107) annotations using Spring’s existing cache configuration and infrastructure abstraction; no changes are required to use the standard annotations.

Started 6 Mars 2001, finished march 2014. There is no point to use JCache. Spring Cache has more features.


##### A Controller can now return a ListenableFuture [[1]](src/main/java/demo/_41/async)

> ListenableFuture is supported as a return value alternative to DeferredResult where an underlying service (or perhaps a call to AsyncRestTemplate) already returns ListenableFuture.

Alternative to DeferredResult. Ease async and non blocking development.

##### Jackson’s @JsonView is supported directly on @ResponseBody and ResponseEntity [[1]](src/main/java/demo/_41/jsonview)

> Jackson’s @JsonView is supported directly on @ResponseBody and ResponseEntity controller methods for serializing different amounts of detail for the same POJO (e.g. summary vs. detail page).

Allow to serialize different amounts of detail for the same POJO.

Open in your browser:
* [http://localhost:8090/ws/user/summary](http://localhost:8090/ws/user/summary)
* [http://localhost:8090/ws/user/detail](http://localhost:8090/ws/user/detail)

##### JSONP is now supported with Jackson [[1]](src/main/java/demo/_41/jsonp)

Open in your browser:
* [http://localhost:8090/ws/user/summary?callback=jsonpLoader](http://localhost:8090/ws/user/summary?callback=jsonpLoader)


##### @ControllerAdvice and ResponseBodyAdvice [[1]](src/main/java/demo/_41/interceptor)

> A new lifecycle option is available for intercepting @ResponseBody and ResponseEntity methods just after the controller method returns and before the response is written. To take advantage declare an @ControllerAdvice bean that implements ResponseBodyAdvice. The built-in support for @JsonView and JSONP take advantage of this.

##### ResponseEntity provides a builder-style [[1]](src/main/java/demo/_41/responseentity)

> ResponseEntity provides a builder-style API to guide controller methods towards the preparation of server-side responses, e.g. ResponseEntity.ok().

##### TestTransaction API [[1]](test/main/java/demo/_41/transactional)

> Test-managed transactions can now be programmatically started and ended within transactional test methods via the new TestTransaction API.


##### @Sql and @SqlConfig [[1]](test/main/java/demo/_41/sql)

> SQL script execution can now be configured declaratively via the new @Sql and @SqlConfig annotations on a per-class or per-method basis.

##### @TestPropertySource [[1]](test/main/java/demo/_41/property)

> Test property sources which automatically override system and application property sources can be configured via the new @TestPropertySource annotation.

Get ride of the `application-test.properties` ?


##### TestExecutionListeners [[1]](test/main/java/demo/_41/listener) [[2]](src/test/resources/META-INF/spring.factories)

> Default TestExecutionListeners can now be automatically discovered.

As soon as thet are added to `spring.factories`.



## Spring 4.2


##### @Bean get detected and processed on Java 8 default methods [[1]](src/main/java/demo/_42/configuration) [[2]](test/main/java/demo/_42/configuration)

> Annotations such as @Bean get detected and processed on Java 8 default methods as well, allowing for composing a configuration class from interfaces with default @Bean methods.

For example API may define `@Configuration` as interface, thus not `@Import`able, and not instanciable.


##### Configuration classes may declare an `@Order` value [[1]](src/main/java/demo/_42/configurationorder) [[2]](test/main/java/demo/_42/configurationorder)

> Configuration classes may declare @Import with regular component classes now, allowing for a mix of imported configuration classes and component classes.


##### `@EventListener` provides annotation event support [[1]](src/main/java/demo/_42/event) [[2]](test/main/java/demo/_42/event)

> The application event infrastructure now offers an annotation-based model as well as the ability to publish any arbitrary event.

Finally an alternative to Guava EventBus.


##### `@TransactionalEventListener` provides transaction-bound event support. [[1]](src/main/java/demo/_42/transactionalevent) [[2]](test/main/java/demo/_42/transactionalevent)

An event oriented alternative to `TransactionSynchronizationManager#registerSynchronization`.

##### `@AliasFor` [[1]](src/main/java/demo/_42/aliasfor)

> Spring Framework 4.2 introduces first-class support for declaring and looking up aliases for annotation attributes. The new @AliasFor annotation can be used to declare a pair of aliased attributes within a single annotation or to declare an alias from one attribute in a custom composed annotation to an attribute in a meta-annotation.

Open in your browser [http://localhost:8090/aliasfor](http://localhost:8090/aliasfor)

!!! Does not work, `Cacheable`annotations is not merged, see [SPR-13475](https://jira.spring.io/browse/SPR-13475)


##### HTTP Streaming and Server-Sent Events support [[1]](src/main/java/demo/_42/eventstream)
Open in your browser:
[http://localhost:8090/event](http://localhost:8090/event)

##### @CrossOrigin [[1]](src/main/java/demo/_42/cors)

> Built-in support for CORS including global (MVC Java config and XML namespace) and local (e.g. @CrossOrigin) configuration. See Chapter 26, CORS Support for details.

Open in your browser [http://localhost:8090/cors](http://localhost:8090/cors)

##### HTTP caching updates new CacheControl [[1]](src/main/java/demo/_42/cache)

> HTTP caching updates new CacheControl builder; plugged into ResponseEntity, WebContentGenerator, ResourceHttpRequestHandler.

Open in your browser:
[http://localhost:8090/cache](http://localhost:8090/cache)

##### RequestBodyAdvice extension point [[1]](src/main/java/demo/_42/interceptor)

> New RequestBodyAdvice extension point and built-in implementation to support Jackson’s @JsonView on @RequestBody method arguments.

Open in your browser [http://localhost:8090/interceptor](http://localhost:8090/interceptor)

##### SpringClassRule, SpringMethodRule [[1]](test/main/java/demo/_42/rule)

> JUnit-based integration tests can now be executed with JUnit rules instead of the SpringJUnit4ClassRunner. This allows Spring-based integration tests to be run with alternative runners like JUnit’s Parameterized or third-party runners such as the MockitoJUnitRunner.


##### Spring MVC Test framework now provides first-class support for HtmlUnit [[1]](test/main/java/demo/_42/htmlunit)

> The Spring MVC Test framework now provides first-class support for HtmlUnit, including integration with Selenium’s WebDriver, allowing for page-based web application testing without the need to deploy to a Servlet container.


##### @Commit and @Rollack are a new annotations that may be used [[1]](test/main/java/demo/_42/transactional)

> @Commit is a new annotation that may be used as a direct replacement for @Rollback(false). @Rollback may now be used to configure class-level default rollback semantics.

@TransactionConfiguration is deprecated


## Reference

[Spring 4.2 Reference Documentation](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/htmlsingle/#spring-whats-new)

## Next ?

* [Coming up in 2016: Spring Framework 4.3 & 5.0](https://spring.io/blog/2015/08/03/coming-up-in-2016-spring-framework-4-3-5-0)
* [High Level Plans for Spring 4.3 and 5.0 Announced at SpringOne2GX](http://www.infoq.com/news/2015/09/spring-43-5)


