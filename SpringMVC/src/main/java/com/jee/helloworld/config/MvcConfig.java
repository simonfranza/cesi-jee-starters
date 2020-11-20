package com.jee.helloworld.config;

import com.jee.helloworld.interceptors.RequireAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// enable spring web MVC
@EnableWebMvc
//set class as a configuration class
@Configuration
// set directory for scan to get spring components
@ComponentScan({"com.jee.helloworld.controller","com.jee.helloworld.model"  })
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();   // Bean View Resolver
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new RequireAuthInterceptor())
                .addPathPatterns("/earthquake/**")
                .addPathPatterns("/flight/**");
    }
}
