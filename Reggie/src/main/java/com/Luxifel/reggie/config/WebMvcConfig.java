package com.Luxifel.reggie.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
     * Mvc资源配置
     * @Configuration注解该类为配置类
     * 继承WebMvcConfigurationSupport并重写addResourceHandlers
     * */
    @Slf4j
    @Configuration
    public class WebMvcConfig extends WebMvcConfigurationSupport {
        @Override
        protected void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:8080/")
    //                .allowedOriginPatterns("*") //允许跨域的域名，可以用*表示允许任何域名使用
                    .allowedMethods("*")
    //                .allowedMethods("POST", "GET", "OPTIONS", "DELETE", "PUT", "PATCH")
                    .allowedHeaders("*")
    //                .allowedHeaders("Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With", "uid", "platform", "userToken", "deviceInfo")
                    .allowCredentials(true)
                    .maxAge(3600);


            // add external api Mapping
    //        registry.addMapping("/api/*")
    //                .allowedOriginPatterns("http://10.1.1.1:8888")
    //                .allowedMethods("POST", "GET", "OPTIONS", "DELETE", "PUT", "PATCH")
    //                .allowedHeaders("Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With")
    //                .allowCredentials(true)
    //                .maxAge(3600);
        super.addCorsMappings(registry);
    }
    /**
     * 设置响应字符编码格式
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream()
            // 过滤出StringHttpMessageConverter类型实例
            .filter(StringHttpMessageConverter.class::isInstance)
            .map(c -> (StringHttpMessageConverter) c)
            // 这里将转换器的默认编码设置为utf-8
            .forEach(c -> c.setDefaultCharset(StandardCharsets.UTF_8));
    }
    /**
     * 设置静态资源映射
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * classpath对应resources文件夹
         * 映射请求路径为资源文件路径
         */
//        log.info("开始进行静态资源映射🥰");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
        super.addResourceHandlers(registry);
    }

    /**
     *  Long类型数据，后端传给前端产生的精度丢失的问题
     * */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1.需要定义一个convert转换消息的对象
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        //2.添加fastJson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
        //3.设置Long为字符串
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        fastJsonConfig.setSerializeConfig(serializeConfig);
        converter.setFastJsonConfig(fastJsonConfig);
        converters.add(converter);
    }
}
