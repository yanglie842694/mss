# mss微服务demo

## 构建docker镜像
#####maven的setting.xml中配置
```xml
<!-- docker私有仓库配置 -->
 <server>
    <id>docker-registry</id>
    <username>admin</username>
    <password>admin123</password>
    <configuration>
      <email>837011700@qq.com</email>
    </configuration>
  </server>
```
```xml
<!-- 配置maven的阿里云加速 -->
<mirror>
    <id>nexus-aliyun</id>
    <mirrorOf>*</mirrorOf>
    <name>Nexus aliyun</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public</url>
</mirror> 
```
#####构建镜像
```shell script
mvn clean package dockerfile:build
```
#####推送镜像到私有仓库
```shell script
mvn clean package dockerfile:push
```
#####公共依赖模块问题
公共依赖模块被多个其他的依赖，所以需要先进行打包
```shell script
mvn clean package install
```
##### nacos修改mysql支持8.x
[从5.7升级到8.x](https://blog.csdn.net/weixin_34233421/article/details/94331205)
[Nacos1.1.4支持Mysql8.0](https://blog.csdn.net/u012480990/article/details/102780908)

#####build nacos
```shell script
mvn -Prelease-nacos -DskipTests clean install -U
```