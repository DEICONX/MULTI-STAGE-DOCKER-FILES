# MULTI-STAGE-DOCKER

## Project Overview
This project demonstrates **multi-stage Docker builds** for different technologies: Java, JavaScript, Python, and .NET. Each technology has its own Dockerfile and follows best practices for building lightweight production images.

The workflow:
- SSH into the server

- Create a directory `MULTI-STAGE-DOCKER`

  ![](Screenshot%202025-11-21%20142307.png)

- Write individual Dockerfiles for each technology

- Build Docker images

- Push images to Docker Hub

## Technologies Used
- **Java** (Tomcat + Maven)
- **JavaScript** (Node.js)
- **Python** (Flask/Django or similar)
- **.NET** (ASP.NET Core)
- **Docker**

## Directory Structure
```
MULTI-STAGE-DOCKER/
├── Dockerfile.java
├── Dockerfile.javascript
├── Dockerfile.python
├── Dockerfile.dotnet
```

## 📄 Dockerfile Details
- **Dockerfile.java** → Multi-stage build: clone repo → build with Maven → deploy on Tomcat

  ![](Screenshot%202025-11-21%20142433.png)

- **Dockerfile.javascript** → Multi-stage build: clone repo → build Node.js app → run with Node

  ![](Screenshot%202025-11-21%20142538.png)

- **Dockerfile.python** → Multi-stage build: clone repo → install dependencies → run Python app

  ![](Screenshot%202025-11-21%20142627.png)

- **Dockerfile.dotnet** → Multi-stage build: clone repo → build with .NET SDK → run with ASP.NET runtime

  ![](<Screenshot 2025-11-21 142704.png>)

## Steps to Build Images
Run the following commands for each technology:

### Java
```bash
docker build -t java-app -f Dockerfile.java .
```

![](<Screenshot 2025-11-21 143701.png>)

### JavaScript

```bash
docker build -t js-app -f Dockerfile.javascript .
```

![](<Screenshot 2025-11-21 144530.png>)

### Python

```bash
docker build -t python-app -f Dockerfile.python .
```

![](<Screenshot 2025-11-21 145708.png>)

### .NET

```bash
docker build -t dotnet-app -f Dockerfile.dotnet .
```

## Push to Docker Hub(optional)

Login to Docker Hub:
```bash
docker login
```

![](<Screenshot 2025-11-21 144146.png>)

Tag and push each image:

```bash
docker tag java-app <dockerhub-username>/java-app:latest
docker push <dockerhub-username>/java-app:latest

# Repeat for js-app, python-app, dotnet-app
```

![](<Screenshot 2025-11-21 145851.png>)

## ✅ Summary

You have successfully:
- Created multi-stage Dockerfiles

- Built images for Java, JavaScript, Python, and .NET

- Uploaded them to Docker Hub

  
