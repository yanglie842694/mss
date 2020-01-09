package cn.yl.admin.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerBeanMapperConfig {

    @Bean(name = "dozerMapper")
    public DozerBeanMapper dozerMapper(){
        return new DozerBeanMapper();
    }
}
