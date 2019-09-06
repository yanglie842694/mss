package cn.yl.auth.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "cn.yl.auth.client")
public class FeignConfig {
}
