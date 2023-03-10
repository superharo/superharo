package online.superh.boot.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.concurrent.TimeUnit;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2022-12-19 15:52
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private Integer port;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n---------------------------------------------------------" +
                            "\n应用启动成功:{}" +
                            "\n本地访问路径:{}" +
                            "\nSQL监控面板:{}" +
                            "\nGithub_仓库:{}" +
                            "\n----------------------------------------------------------",
                    applicationName,
                    "http://localhost:"+port,
                    "http://localhost:"+port+"/druid/sql.html",
                    "https://github.com/superharo/superharo");
        });
    }
}
