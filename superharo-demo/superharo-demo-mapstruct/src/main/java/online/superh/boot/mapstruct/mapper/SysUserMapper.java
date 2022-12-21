package online.superh.boot.mapstruct.mapper;

import online.superh.boot.mapstruct.pojo.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 22497
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2022-12-21 11:50:59
* @Entity generator.online.superh.boot.mapstruct.pojo.SysUser
*/
@Mapper
// mybatis-plus的basePackage(会自动取spring boot的应用启动路径作为basePackage)下的@Mapper注册为bean
public interface SysUserMapper extends BaseMapper<SysUser> {

}




