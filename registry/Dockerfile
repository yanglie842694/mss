FROM java:jre
MAINTAINER Lie Yang <837011700@qq.com>

#WORKDIR /var/lib/docker/tmp/
ADD ./target/registry.jar /home/vagrant/app/
CMD ["java", "-Xmx200m","-Duser.timezone=GMT+08", "-jar", "/home/vagrant/app/registry.jar"]

EXPOSE 8761