#This is comment - instructions to build image for our project!!!!!
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

LABEL maintainer="technohunk100@gmail.com"

ENV MVN_BUILD_DIR=/build/

RUN mkdir -p $MVN_BUILD_DIR

WORKDIR $MVN_BUILD_DIR

#COPY . /build/

# 1. add pom.xml only here
ADD pom.xml $MVN_BUILD_DIR

#RUN mvn dependency:go-offline
# 2. start downloading dependencies
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]

# 3. add all source code and start compiling
ADD . $MVN_BUILD_DIR

#RUN mvn clean package -DskipTests
#FROM MAVEN_BUILD as mavenPackage
#/build/
RUN mvn install -nsu -DskipTests 

FROM openjdk:8-jre-alpine
WORKDIR /app

EXPOSE 8080

COPY --from=MAVEN_BUILD /build/banking-web/target/banking-web-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java","-jar","banking-web-0.0.1-SNAPSHOT.jar"]