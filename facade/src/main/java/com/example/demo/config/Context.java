package com.example.demo.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Context {

    @Bean(name = "hystrixRegistrationBean")
    public ServletRegistrationBean servletRegistrationBean(@Value("${facade.hystrix.stream.endpoint}") String hystrixEndpoint) {
        ServletRegistrationBean<HystrixMetricsStreamServlet> registration =
            new ServletRegistrationBean<>(new HystrixMetricsStreamServlet(), hystrixEndpoint);
        registration.setName("hystrixServlet");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
