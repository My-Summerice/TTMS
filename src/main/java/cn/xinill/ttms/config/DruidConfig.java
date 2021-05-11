package cn.xinill.ttms.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;

/**
 * @Author: Xinil
 * @Date: 2021/3/8 14:12
 *
 * Druid 数据源配置类
 */
@Configuration
public class DruidConfig {

    @Bean
    // 将所有前缀为spring.datasource下的配置项都加载DataSource中
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置 Druid后台监控，内置了servlet容器， 使用 ServletRegistrationBean来替代 web.xml
     */
    @Bean
    public ServletRegistrationBean<Servlet> statViewServlet() {
        //创建servlet注册实体
        ServletRegistrationBean<Servlet> srb = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        // 白名单
        srb.addInitParameter("allow", "127.0.0.1");
        // 黑名单
        srb.addInitParameter("deny", "");
        // 用户名
        srb.addInitParameter("loginUsername", "root");
        // 密码
        srb.addInitParameter("loginPassword", "root");
        // 是否可以重置数据源
        srb.addInitParameter("resetEnable", "false");
        return srb;
    }

    /**
     *     Filter 过滤器
     */
    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        //创建过滤器
        FilterRegistrationBean<Filter> frb = new FilterRegistrationBean<>();
        //设置过滤器
        frb.setFilter(new WebStatFilter());
        // 所有请求进行监控处理
        frb.addUrlPatterns("/*");
        // 设置排除的请求名单
        frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
        return frb;
    }

}