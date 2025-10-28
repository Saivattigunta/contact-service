# Contact Service

A Spring Boot REST API service for handling contact form submissions. This service provides endpoints to receive, process, and manage contact form data.

## Features

- RESTful API endpoints for contact form submissions
- Spring Security integration for API protection
- Spring Boot auto-configuration
- Maven build system
- Java 21 support
- Lombok for reducing boilerplate code

## Prerequisites

- Java 21 or higher
- Maven 3.6+ or use the included Maven wrapper (`mvnw`)

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd contact-service
```

### 2. Build the Project

Using Maven wrapper (recommended):
```bash
./mvnw clean install
```

Or using Maven directly:
```bash
mvn clean install
```

### 3. Run the Application

Using Maven wrapper:
```bash
./mvnw spring-boot:run
```

Or using Maven directly:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` by default.

### 4. Build and Run with JAR

```bash
./mvnw clean package
java -jar target/contact.service-0.0.1-SNAPSHOT.jar
```

## API Documentation

### Swagger UI
The application includes Swagger UI for interactive API documentation and testing:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## API Endpoints

The service provides the following REST endpoints:

### Contact Form Submission
- **POST** `/api/contact` - Submit a contact form
- **GET** `/api/contact` - Retrieve all contact submissions
- **GET** `/api/contact/{id}` - Get specific contact submission by ID
- **GET** `/api/contact/health` - Health check endpoint

### Health Check
- **GET** `/actuator/health` - Application health status

## Configuration

The application uses `application.properties` for configuration. Key properties:

```properties
spring.application.name=contact.service
server.port=8080
```

## Security

This application includes Spring Security. For development purposes, you may need to configure security settings or disable authentication for testing.

## Development

### Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/mkg/contact/service/
│   │       └── Application.java
│   └── resources/
│       ├── application.properties
│       ├── static/
│       └── templates/
└── test/
    └── java/
        └── com/mkg/contact/service/
            └── ApplicationTests.java
```

### Adding New Features

1. Create your controller classes in the `com.mkg.contact.service` package
2. Add service classes for business logic
3. Create model/entity classes for data representation
4. Add tests in the corresponding test package

## Testing

### Unit Tests
Run tests using Maven:

```bash
./mvnw test
```

### API Testing with Swagger UI
1. Start the application: `./mvnw spring-boot:run`
2. Open Swagger UI: `http://localhost:8080/swagger-ui.html`
3. Use the interactive interface to test all endpoints:
   - Try the **POST /api/contact** endpoint with sample data:
     ```json
     {
       "name": "John Doe",
       "email": "john.doe@example.com",
       "subject": "Test Inquiry",
       "message": "This is a test message from Swagger UI"
     }
     ```
   - Use **GET /api/contact** to retrieve all submissions
   - Use **GET /api/contact/{id}** to get a specific submission

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support and questions, please open an issue in the GitHub repository.
