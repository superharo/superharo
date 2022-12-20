package online.superh.boot.mapstruct.convert;

import online.superh.boot.mapstruct.pojo.Department;
import online.superh.boot.mapstruct.pojo.User;
import online.superh.boot.mapstruct.vo.UserDetailVO;
import online.superh.boot.mapstruct.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2022-12-19 18:25
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class); // <2>

    UserVO convert(User user);

    /**
     * @Mapping 注解，配置相应的映射关系
     * @param user
     * @return
     */
    @Mappings(value = {
            @Mapping(source = "id", target = "userId")
    })
    UserDetailVO convertDetail(User user);

    /**
     * @Mapping 注解还支持多个对象转换为一个对象
     */
    @Mappings(value = {
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "department.id", target = "deptId")
    })
    UserDetailVO convertDetail(User user, Department department);

}
