FROM java:jre
MAINTAINER Lie Yang <837011700@qq.com>

#WORKDIR /var/lib/docker/tmp/
ADD ./target/admin-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m","-Duser.timezone=GMT+08", "-jar", "/app/admin.jar"]

EXPOSE 4000