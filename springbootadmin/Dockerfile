FROM openjdk:8-jre-alpine
MAINTAINER Lie Yang <837011700@qq.com>

#WORKDIR /var/lib/docker/tmp/
ADD ./target/springbootadmin.jar /app/
CMD ["java", "-Xmx200m","-Duser.timezone=GMT+08", "-jar", "/app/springbootadmin.jar"]