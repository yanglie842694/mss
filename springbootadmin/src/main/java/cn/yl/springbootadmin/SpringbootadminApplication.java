package cn.yl.springbootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableAdminServer
@EnableDiscoveryClient
@EnableFeignClients
public class SpringbootadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootadminApplication.class, args);
    }

}
