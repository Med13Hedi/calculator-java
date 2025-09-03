# Lab 1 - Manual Docker CI/CD Pipeline for Java App

## Goal
- Experience manual Docker build and deployment workflow for Java application
- Understand container-based deployment strategy for Java/Maven projects
- Document pain points of manual Docker processes

## Prerequisites
- Java 17+ and Maven installed
- Docker installed and running
- Docker Hub account (free)
- Railway CLI installed (`npm install -g @railway/cli`)
- Railway account created

## Setup Docker Hub (5 minutes)
1. Create free Docker Hub account at https://hub.docker.com
2. Login to Docker Hub locally:
   ```bash
   docker login
   # Enter your Docker Hub username and password
   ```

## Manual Docker CI/CD Pipeline for Java App (20 minutes)

### Step 1: Build Java Application (Optional - Docker will do this)
```bash
mvn clean compile
mvn test
mvn package
```
**Observe:** Maven build time, test execution, JAR file creation in `target/` directory

### Step 2: Build Docker Image
```bash
# Build Docker image
docker build -t <your-username>/java-app:latest .

# Verify image was created
docker images | grep java-app
```
**Observe:** Docker build time with Maven compilation, image size, multi-stage build layers

### Step 3: Test Docker Image Locally
```bash
# Run container locally
docker run -p 8080:8080 <your-username>/java-app:latest

# Test in browser: http://localhost:8080
# Test API: curl http://localhost:8080/ping
# Stop container: Ctrl+C
```
**Observe:** Container startup time, application behavior in containerized environment

### Step 4: Push to Docker Hub
```bash
# Push image to registry
docker push <your-username>/java-app:latest

# Verify on Docker Hub website that image appears in your repositories
```
**Observe:** Upload time, image size being transferred

### Step 5: Deploy to Railway using Docker
```bash
# Simple deployment - no file swapping needed!
railway up --detach

# Get the deployment URL
railway domain
railway open
```
**Observe:** Deployment time, Railway building image from source code, build logs

## Pain Points to Document

### Docker Complexity for Java (Now Simplified):
- **Build Time**: Maven + Docker build takes longer than direct deployment (but now streamlined)
- **Larger Images**: Java container images are typically larger than Node.js
- **Registry Management**: Need to manage Docker Hub repositories for sharing
- **Memory Configuration**: JVM memory settings in containers
- **Startup Time**: Java applications have longer cold start times

### Java-Specific Docker Benefits:
- **Universal Build**: Single Dockerfile works everywhere (local, Railway, any platform)
- **Consistent Environment**: Same build process across all environments
- **Dependency Management**: Maven dependencies are handled automatically
- **Layer Caching**: Docker caches Maven dependencies for faster rebuilds
- **Platform Independence**: Runs anywhere Docker is supported

## Docker vs Direct Deployment for Java

| Aspect | Direct Deployment | Docker Deployment |
|--------|------------------|-------------------|
| **Build Steps** | mvn package | mvn package + docker build (local)<br/>or multi-stage build (cloud) |
| **Artifacts** | JAR file | Container image |
| **Size** | ~20MB JAR | ~200MB+ container |
| **Startup** | Direct JVM | Container + JVM |
| **Complexity** | Simple Maven | Maven + Docker |
| **Portability** | JVM dependent | Platform independent |

## Troubleshooting

### Common Issues

**Docker build fails with "No such file"**
```bash
# Solution: Ensure JAR exists
mvn package
ls target/*.jar  # Verify JAR file exists
```

**Container exits immediately**
```bash
# Solution: Check logs
docker logs <container-id>
# Verify JAR file in container
docker run -it <username>/java-app:latest sh
```

**Port already in use**
```bash
# Solution: Use different port
docker run -p 9090:8080 username/java-app:latest
```

## Reflection Questions

1. How much additional time does Docker add to Java deployment?
2. What are the benefits of containerizing Java applications?
3. How does image size impact deployment speed?
4. What happens if Maven build fails vs Docker build fails?
5. How would you handle different Java versions across environments?

## Next Steps
- Compare this manual Docker process with automated GitHub Actions
- Consider multi-stage Docker builds for smaller images
- Explore Java-specific Docker optimizations
