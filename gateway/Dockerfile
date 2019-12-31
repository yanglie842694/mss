FROM openjdk:8-jre-alpine
MAINTAINER Lie Yang <837011700@qq.com>

#WORKDIR /var/lib/docker/tmp/
ADD ./target/gateway.jar /home/vagrant/app/
CMD ["java", "-Xmx200m","-Duser.timezone=GMT+08", "-jar", "/home/vagrant/app/gateway.jar"]

EXPOSE 4000