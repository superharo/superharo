package online.superh.boot.framework.banner.config;

import online.superh.boot.framework.banner.core.BannerApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: 1.0
 * @author: haro
 * @description:  Banner 的自动配置类
 * @date: 2022-12-19 15:42
 */
//不使用代理加快启动速度
@Configuration(proxyBeanMethods = false)
public class SuperharoBannerAutoConfiguration {

    @Bean
    public BannerApplicationRunner bannerApplicationRunner() {
        return new BannerApplicationRunner();
    }

}
