# Spring Boot Application

A Spring Boot 3.x application built with Maven and Java 17.

## Project Structure

```
.
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── SpringBootAppApplication.java
│   │   │   └── controller/
│   │   │       └── HelloController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## Prerequisites

- Java 17 or higher
- Maven 3.6+

## Getting Started

### Build the Application

Run the following command to build the project:

```bash
mvn clean package
```

You can also use the VS Code task `Build Spring Boot App` from the Command Palette (Ctrl+Shift+P or Cmd+Shift+P).

### Run the Application

To run the application locally:

```bash
mvn spring-boot:run
```

Or use the VS Code task `Run Spring Boot App` from the Command Palette.

The application will start on `http://localhost:8080`

## API Endpoints

- `GET /` - Returns "Hello, Spring Boot!"
- `GET /api/greeting` - Returns "Welcome to your Spring Boot application!"

## Adding Dependencies

To add new dependencies, edit `pom.xml` and add the dependency to the `<dependencies>` section. Then rebuild the project.

Example:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

## Project Configuration

Configuration is managed through `src/main/resources/application.properties`. You can customize:

- `spring.application.name` - Application name
- `server.port` - Server port (default: 8080)

## Testing

Run tests with:

```bash
mvn test
```

## Build Options

- `mvn clean` - Clean build artifacts
- `mvn compile` - Compile source code
- `mvn package` - Create JAR file
- `mvn install` - Install to local Maven repository
- `mvn spring-boot:run` - Run the application directly

## Next Steps

1. Customize the application name and package in `pom.xml`
2. Add business logic to the controller classes
3. Add new dependencies as needed
4. Configure application properties for your environment
5. Create additional controllers and services as required
