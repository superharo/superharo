package online.superh.boot.framework.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.List;

/**
 * @version: 1.0
 * @author: haro
 * @description: Xss 配置属性
 * @date: 2022-12-20 14:54
 */
@ConfigurationProperties(prefix = "superharo.xss")
@Data
public class XssProperties {

    /**
     * 是否开启，默认为 true
     */
    private boolean enable = true;
    /**
     * 需要排除的 URL，默认为空
     */
    private List<String> excludeUrls = Collections.emptyList();

}
