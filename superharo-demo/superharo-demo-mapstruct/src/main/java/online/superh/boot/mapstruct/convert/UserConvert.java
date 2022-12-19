package online.superh.boot.mapstruct.convert;

import online.superh.boot.mapstruct.pojo.User;
import online.superh.boot.mapstruct.vo.UserVO;
import org.mapstruct.Mapper;
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

}
