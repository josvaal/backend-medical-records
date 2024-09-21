package com.josval.backend.filter;

import com.josval.backend.filter.component.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig{
  @Bean
  public FilterRegistrationBean<AuthFilter> loggingFilter(){
    FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new AuthFilter());
    registrationBean.addUrlPatterns("/api/v1/*");
    registrationBean.setOrder(2);

    return registrationBean;
  }
}