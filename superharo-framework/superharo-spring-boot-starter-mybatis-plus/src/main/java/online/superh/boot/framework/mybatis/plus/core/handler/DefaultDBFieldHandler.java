package online.superh.boot.framework.mybatis.plus.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * @version: 1.0
 * @author: haro
 * @description: 通用参数填充实现类
 * 如果没有显式的对通用参数进行赋值，这里会对通用参数进行填充、赋值
 * @date: 2022-12-21 10:11
 */
public class DefaultDBFieldHandler implements MetaObjectHandler {


    /**
     * 自动插入值
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    }

    /**
     * 自动更新值
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 起始版本 3.3.0(推荐使用)
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }

}
