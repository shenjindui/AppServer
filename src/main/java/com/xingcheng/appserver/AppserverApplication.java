package com.xingcheng.appserver;

import com.xingcheng.appserver.config.filter.JwtAuthenticationTokenFilter;
import com.xingcheng.appserver.utils.util.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AppserverApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(AppserverApplication.class, args);
        new SpringContextHolder().setApplicationContext(cac);
    }
    @Bean
    public FilterRegistrationBean registration(JwtAuthenticationTokenFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}
