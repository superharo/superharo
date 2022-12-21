package online.superh.boot.mapstruct;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// maybatis-plus 会自动扫描 启动类路径下的@mappper,启动类配置 @MapperScan 避免 maybatis-plus 和 maybatis 扫描冲突
@MapperScan(value = "${superharo.info.base-package}", annotationClass = Mapper.class)
public class MapstructApplication {
    public static void main(String[] args) {
        SpringApplication.run(MapstructApplication.class,args);
    }
}