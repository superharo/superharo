package online.superh.boot.common.constants;

/**
 * @version: 1.0
 * @author: haro
 * @description: Web 过滤器顺序
 * @date: 2022-12-20 15:12
 */
public interface WebFilterOrderConstant {

    /** 跨域过滤 **/
    Integer CORS_FILTER = Integer.MIN_VALUE;

    /** 请求体过滤 **/
    Integer REQUEST_BODY_CACHE_FILTER = Integer.MIN_VALUE + 500;

    Integer XSS_FILTER = -102;  // 需要保证在 RequestBodyCacheFilter 后面

    // Spring Security Filter 默认为 -100，可见 org.springframework.boot.autoconfigure.security.SecurityProperties 配置属性类

}
