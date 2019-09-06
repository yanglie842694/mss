package cn.yl.common;

import cn.yl.common.vo.PlatResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨列
 */
@SpringBootApplication
@RestController
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

    @RequestMapping("/test")
    public PlatResult test(){
        return PlatResult.success("你好");
    }
}
