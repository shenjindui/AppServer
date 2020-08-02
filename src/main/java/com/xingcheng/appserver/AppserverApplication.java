package com.xingcheng.appserver;

import com.xingcheng.appserver.config.filter.JwtAuthenticationTokenFilter;
import com.xingcheng.appserver.service.ISysSettingService;
import com.xingcheng.appserver.utils.util.ErrorUtil;
import com.xingcheng.appserver.utils.util.SpringContextHolder;
import com.xingcheng.appserver.utils.util.SysSettingUtil;
import com.xingcheng.appserver.vo.SysSettingVo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableJpaAuditing
@SpringBootApplication
@MapperScan("com.xingcheng.appserver.mapper")
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

@Slf4j
@Controller
@RequestMapping("/")
@Configuration
class IndexController {

    @Autowired
    private ISysSettingService sysSettingService;

    /**
     * 端口
     */
    @Value("${server.port}")
    private String port;

    /**
     * 启动成功
     */
    @Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
            try {
                //系统启动时获取数据库数据，设置到公用静态集合sysSettingMap
                SysSettingVo sysSettingVo = sysSettingService.get("123456789876543234567890").getData();
                sysSettingVo.setUserInitPassword(null);//隐藏部分属性
                SysSettingUtil.setSysSettingMap(sysSettingVo);
                //获取本机内网IP
                log.info("启动成功：" + "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port + "/xingcheng/swagger-ui.html");
            } catch (UnknownHostException e) {
                //输出到日志文件中
                log.error(ErrorUtil.errorInfoToString(e));
            }
        };
    }
}