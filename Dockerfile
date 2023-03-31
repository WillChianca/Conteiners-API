FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/api-lang-0.0.1-SNAPSHOT.jar apilang.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar apilang.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar apilang.jar
