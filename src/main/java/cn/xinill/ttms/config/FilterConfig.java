package cn.xinill.ttms.config;

import cn.xinill.ttms.filter.CrossFilter;
//import cn.xinill.ttms.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Xinil
 * @Date: 2021/1/31 22:27
 *
 * 过滤器配置类
 */
@Configuration
public class FilterConfig {
    /**
     * 配置跨域访问的过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean registerFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addUrlPatterns("/*");
        registration.setFilter(new CrossFilter());
        registration.setName("crosFilter");
        registration.setOrder(1);
        return registration;
    }

//    /**
//     * 用户 token过滤器
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean registFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new LoginFilter());
//        registration.addUrlPatterns("/user/inform/*", "/img/*");
//        registration.setName("tokenFilter");
//        registration.setOrder(1);
//        return registration;
//    }
}