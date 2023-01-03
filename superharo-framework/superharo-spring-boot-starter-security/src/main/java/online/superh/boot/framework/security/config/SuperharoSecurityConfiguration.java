package online.superh.boot.framework.security.config;

import online.superh.boot.framework.security.core.api.OAuth2TokenApi;
import online.superh.boot.framework.security.core.api.PermissionApi;
import online.superh.boot.framework.security.core.filter.TokenAuthenticationFilter;
import online.superh.boot.framework.security.core.handler.AuthenticationEntryPointImpl;
import online.superh.boot.framework.security.core.service.SecurityFrameworkService;
import online.superh.boot.framework.security.core.service.SecurityFrameworkServiceImpl;
import online.superh.boot.framework.web.core.handler.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

/**
 * @version: 1.0
 * @author: haro
 * @description: Spring Security 自动配置类，主要用于相关组件的配置
 * @date: 2022-12-26 10:12
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SecurityProperties.class)
public class SuperharoSecurityConfiguration {

    @Autowired
    private SecurityProperties securityProperties;


    /**
     * 认证失败处理器
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPointImpl();
    }

    /**
     * 权限不够处理器
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new AccessDeniedHandlerImpl();
    }


    /**
     * Spring Security 加密器
     * 考虑到安全性，这里采用 BCryptPasswordEncoder 加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Token 认证过滤器 Bean
     */
    @Bean
    public TokenAuthenticationFilter authenticationTokenFilter(GlobalExceptionHandler globalExceptionHandler, OAuth2TokenApi oauth2TokenApi) {
        return new TokenAuthenticationFilter(securityProperties, globalExceptionHandler, oauth2TokenApi);
    }

    @Bean("ss") // 使用 Spring Security 的缩写，方便使用
    public SecurityFrameworkService securityFrameworkService(PermissionApi permissionApi) {
        return new SecurityFrameworkServiceImpl(permissionApi);
    }


}
