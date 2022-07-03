package com.icss.config;


import com.icss.util.StringtoDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan("com.icss.controller")
@EnableWebMvc //启动mvc
public class MyMvcConfig implements WebMvcConfigurer {

    //处理静态资源不能被解析
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //文件上传
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver mm = new CommonsMultipartResolver();
        mm.setDefaultEncoding("UTF-8");
        mm.setMaxUploadSize((long) (10 * Math.pow(2, 20)));

        return mm;
    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringtoDate());
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
////        WebMvcConfigurer.super.addInterceptors(registry);
//        InterceptorRegistration registration =
//                registry.addInterceptor(new MyInterptor());
//        registration.excludePathPatterns("/-**");
//        registration.excludePathPatterns("/login");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .exposedHeaders("access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options")
                .maxAge(3600);
    }
}
