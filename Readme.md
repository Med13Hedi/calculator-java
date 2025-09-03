# Java Calculator Web Application

A simple web-based calculator application built with Java, Spark framework, and Maven. This project demonstrates modern Java web development, containerization with Docker, and cloud deployment practices.

## 🚀 Features

- **Basic arithmetic operations**: Addition, Subtraction, Multiplication, Division
- **RESTful API**: JSON-based API for calculator operations
- **Web Interface**: Simple HTML frontend for interactive calculations
- **Health Check**: Built-in health monitoring endpoint
- **CORS Support**: Cross-origin resource sharing enabled
- **Containerized**: Docker support for easy deployment
- **Cloud Ready**: Configured for Railway deployment

## 🛠️ Technology Stack

- **Java 17**: Core programming language
- **Spark Java**: Lightweight web framework
- **Maven**: Build automation and dependency management
- **Gson**: JSON serialization/deserialization
- **JUnit**: Unit testing framework
- **Docker**: Containerization
- **Railway**: Cloud deployment platform

## 📁 Project Structure

```
calculator-java/
├── src/
│   ├── main/
│   │   ├── java/com/ensit/
│   │   │   ├── Calculator.java      # Core calculator logic
│   │   │   └── Main.java           # Web server and API endpoints
│   │   └── resources/static/
│   │       └── index.html          # Web interface
│   └── test/
│       └── java/com/ensit/
│           └── CalculatorTest.java # Unit tests
├── docs/                           # Documentation and guides
├── labs/                          # Laboratory exercises
├── Dockerfile                     # Container configuration
├── railway.toml                   # Railway deployment config
└── pom.xml                       # Maven configuration
```

## 🏃‍♂️ Quick Start

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Docker (optional, for containerization)

### Local Development

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd calculator-java
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run tests**
   ```bash
   mvn test
   ```

4. **Start the application**
   ```bash
   mvn exec:java -Dexec.mainClass="com.ensit.Main"
   ```

5. **Access the application**
   - Web Interface: http://localhost:8080
   - API Base URL: http://localhost:8080

### Using Docker

1. **Build the Docker image**
   ```bash
   docker build -t calculator-java .
   ```

2. **Run the container**
   ```bash
   docker run -p 8080:8080 calculator-java
   ```

## 📚 API Documentation

### Health Check

Check if the application is running:

```http
GET /ping
```

**Response:**
```json
{
  "message": "pong"
}
```

### Calculator Operations

Perform arithmetic calculations:

```http
POST /calculate
Content-Type: application/json

{
  "op": "add",
  "a": 10,
  "b": 5
}
```

**Parameters:**
- `op`: Operation type (`add`, `sub`, `mul`, `div`)
- `a`: First number
- `b`: Second number

**Response:**
```json
{
  "op": "add",
  "a": 10,
  "b": 5,
  "result": 15
}
```

**Supported Operations:**
- `add`: Addition (a + b)
- `sub`: Subtraction (a - b)
- `mul`: Multiplication (a × b)
- `div`: Division (a ÷ b)

**Error Response:**
```json
{
  "error": "Invalid request: <error message>"
}
```

## 🧪 Testing

Run the test suite:

```bash
mvn test
```

The project includes unit tests for the Calculator class to ensure all arithmetic operations work correctly.

## 🚀 Deployment

### Railway Deployment

This project is configured for deployment on Railway:

1. **Connect your repository** to Railway
2. **Set environment variables** (if needed)
3. **Deploy automatically** using the provided `railway.toml` configuration

The application will be accessible at your Railway-provided URL.

### Manual Docker Deployment

1. Build and push to a container registry
2. Deploy to your preferred cloud platform
3. Ensure port 8080 is exposed

## 🔧 Configuration

### Environment Variables

- `PORT`: Server port (default: 8080)
- `JAVA_OPTS`: JVM options (default: -Xmx256m)

### Development Settings

The application automatically:
- Serves static files from `/static`
- Enables CORS for all origins
- Handles preflight requests
- Provides JSON responses

## 📖 Documentation

Additional documentation is available in the `docs/` directory:
- GitHub Secrets Guide
- Railway Deployment Guide
- Screenshots and tutorials

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Ensure all tests pass
6. Submit a pull request

## 📄 License

This project is part of an educational exercise and is provided as-is for learning purposes.

## 🆘 Support

For questions or issues:
1. Check the documentation in the `docs/` folder
2. Review the laboratory exercises in `labs/`
3. Create an issue in the repository

---

**Built with ❤️ for learning Java web development and CI/CD practices**
