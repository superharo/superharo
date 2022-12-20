package online.superh.boot.mapstruct;

import lombok.extern.slf4j.Slf4j;
import online.superh.boot.mapstruct.convert.UserConvert;
import online.superh.boot.mapstruct.pojo.Department;
import online.superh.boot.mapstruct.pojo.User;
import online.superh.boot.mapstruct.vo.UserDetailVO;
import online.superh.boot.mapstruct.vo.UserVO;
import org.junit.jupiter.api.Test;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2022-12-20 9:50
 */
@Slf4j
public class TestMapStruct {

    @Test
    public void testConvert02(){
        // 创建 User 对象
        User user = new User().setId(1).setUsername("haro").setPassword("12345678");
        // 进行转换
        UserDetailVO userDetailVO1 = UserConvert.INSTANCE.convertDetail(user);
        log.info("userDetailVO1:{}",userDetailVO1);
        //多个对象
        Department department = new Department().setId(1111).setName("技术部");
        UserDetailVO userDetailVO2 = UserConvert.INSTANCE.convertDetail(user,department);
        log.info("userDetailVO2:{}",userDetailVO2);
    }
    
    @Test
    public void testConvert(){
        // 创建 User 对象
        User user = new User().setId(1).setUsername("haro").setPassword("12345678");
        // 进行转换
        UserVO userVO = UserConvert.INSTANCE.convert(user);
        log.info("userVO:{}",userVO);
    }
}
