package cn.yl.auth;

import cn.yl.auth.vo.UserVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨列
 */
@SpringCloudApplication
@EnableDiscoveryClient
@RestController
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "cn.yl.auth.dao")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
    @Bean
    public static PasswordEncoder passwordEncoder() {
        Map encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder("bcrypt",encoders);
    }

    @PostMapping(value = "/users/signup")
    public void signUp(@RequestBody UserVO user){
        System.out.println("加密前："+user.getPassword());
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        System.out.println("加密后："+user.getPassword());
    }

    @GetMapping(value = "/getHello")
    @ResponseBody
    public String getHello(){
        String hello = passwordEncoder().encode("123456");
        return hello;
    }
}
