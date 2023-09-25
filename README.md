# Overview

This is simple Spring Boot REST application which can be built to `native Java`, nothing but a native 
executable produced using Spring ahead-of-time (AOT) compilation.

A native image can run standalone without relying on a JVM.

## The following are the dependencies chosen [from](https://start.spring.io/)
```
Project      : Maven  
Languge      : Java 20  
Spring Boot  : 3.1.4
Packaging    : Jar
Dependencies : Lombok, GraalVM Native Support, Spring Web,
```
# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/#build-image)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/3.0.5/reference/html/native-image.html#native-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [GraalVM](https://www.graalvm.org/)
* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/htmlsingle/#aot)
* [Spring Boot banner Generator](https://springhow.com/spring-boot-banner-generator/)
* [Reference](https://blogs.oracle.com/java/post/go-native-with-spring-boot-3-and-graalvm)

# Build

> **NOTE**: GraalVM 22.3+ is required.  
> 
> Make sure that your `JAVA_HOME points` to GraalVM JDK distribution.  
> 
> **e.g. Using SDKMAN**
> ```
> $ sdk install java 20.0.2-graal 
> $ sdk use java 20.0.2-graal
> $ java -version 
> java version "20.0.2" 2023-07-18
> Java(TM) SE Runtime Environment Oracle GraalVM 20.0.2+9.1 (build 20.0.2+9-jvmci-23.0-b14)
> Java HotSpot(TM) 64-Bit Server VM Oracle GraalVM 20.0.2+9.1 (build 20.0.2+9-jvmci-23.0-b14, mixed mode, sharing)
> $
> ```
> 
## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image -Pnative
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 boot-graalvm:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

To create the executable, run the following goal:

```
$ ./mvnw native:compile -Pnative
```

### Running
Then, you can run the app as follows:
```
$ target/boot-graalvm
```

Once the app is running, run the following `curl` command from another terminal window:
```
curl get localhost:8080
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./mvnw test -PnativeTest
```

### Swagger UI
Once the app is up and running, just go to http://localhost:8080/swagger-ui/index.html in the browser to test end-points.