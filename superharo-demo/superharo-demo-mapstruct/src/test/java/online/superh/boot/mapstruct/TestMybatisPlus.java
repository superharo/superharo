package online.superh.boot.mapstruct;

import online.superh.boot.mapstruct.mapper.SysUserMapper;
import online.superh.boot.mapstruct.pojo.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2022-12-21 12:53
 */
@SpringBootTest
public class TestMybatisPlus {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void test01() {
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
       sysUsers.forEach(System.out::println);
    }

}
