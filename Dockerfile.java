# Stage 1: Clone source code
FROM alpine/git AS source
WORKDIR /app
RUN git clone https://github.com/DEICONX/JavaWebCal.git .

# Stage 2: Build with Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY --from=source /app /app
RUN mvn clean package -DskipTests

# Stage 3: Deploy in Tomcat
FROM tomcat:9.0-jdk17-temurin
WORKDIR /usr/local/tomcat/webapps
# Remove default ROOT app if needed
RUN rm -rf ROOT
# Copy WAR file from build stage
COPY --from=build /app/target/*.war ./ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
