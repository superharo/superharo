package online.superh.boot.framework.datasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import online.superh.boot.framework.datasource.core.filter.DruidAdRemoveFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2022-12-21 11:17
 */
@Configuration(proxyBeanMethods = false)
// 启动事务管理
@EnableTransactionManagement
/*

  boolean proxyTargetClass() default false;
     * 指示是否创建基于子类(CGLIB)的代理，而不是标准的基于Java接口的代理(false)。默认为false，即基于Java接口。
     * 仅当mode()设置为AdviceMode.PROXY时适用。

  AdviceMode mode() default AdviceMode.PROXY;
     * 指示应该如何应用事务性通知。
     * 默认为AdviceMode.PROXY，即基于Spring AOP动态代理。请注意，代理模式只允许通过代理拦截调用。
     * 同一个类中的本地方法互相调用中，被调用方法上的事务注解将被忽略，因为Spring的拦截器不会在这样的运行时场景中发挥作用。
     * 对于更高级的拦截模式，考虑将其切换到AdviceMode.ASPECTJ，即以及Aspect的静态织入

 int order() default Ordered.LOWEST_PRECEDENCE;
     * 指示在特定连接点应用多个通知时事务通知器的执行顺序。
     * 默认为Ordered.LOWEST_PRECEDENCE

 */
@EnableConfigurationProperties(DruidStatProperties.class)
public class SuperharoDatatSourseAutoConfiguration {

    /**
     * 创建 DruidAdRemoveFilter 过滤器，过滤 common.js 的广告
     */
    @Bean
    @ConditionalOnProperty(name = "spring.datasource.druid.web-stat-filter.enabled", havingValue = "true")
    public FilterRegistrationBean<DruidAdRemoveFilter> druidAdRemoveFilterFilter(DruidStatProperties properties) {
        // 获取 druid web 监控页面的参数
        DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
        // 提取 common.js 的配置路径
        String pattern = config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*";
        String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");
        // 创建 DruidAdRemoveFilter Bean
        FilterRegistrationBean<DruidAdRemoveFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new DruidAdRemoveFilter());
        registrationBean.addUrlPatterns(commonJsPattern);
        return registrationBean;
    }

}
