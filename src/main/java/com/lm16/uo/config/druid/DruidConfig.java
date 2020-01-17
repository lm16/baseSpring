package com.lm16.uo.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){

        //注册
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

//        白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//        黑名单
//        servletRegistrationBean.addInitParameter("deny", "127.0.0.1");

//        帐户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");

//        是否能够重置
        servletRegistrationBean.addInitParameter("resetEnable", "false");

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        // 过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        // 进行忽略
        filterRegistrationBean.addInitParameter("exclusions", "*.js, *.gif, *.jpg, *.png, *.css, *.ico, /druid/*");

        return filterRegistrationBean;
    }
}
