
package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CrossOriginConfig 类用于配置跨域请求的处理
 * 跨域资源共享（CORS）配置允许来自不同源的请求访问应用的服务
 * 该类实现了 WebMvcConfigurer 接口，以定制 Spring MVC 的配置
 */
@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {

    /**
     * 重写 addCorsMappings 方法以配置跨域请求映射
     * 该方法定义了哪些请求可以被跨域访问
     *
     * @param registry CorsRegistry 对象，用于注册跨域配置
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 匹配所有路径（包括嵌套路径）
                .allowedOrigins("http://localhost:8081") // 前端地址
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "OPTIONS") // 合法的 HTTP 方法
                .allowedHeaders("*") // 允许的 header
                .exposedHeaders("X-Custom-Header") // 暴露的 header
                .allowCredentials(true) // 是否允许发送 Cookie
                .maxAge(3600); // 预检请求缓存时间（单位：秒）

    }
}