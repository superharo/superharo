package online.superh.boot.mapstruct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.superh.boot.mapstruct.pojo.SysUser;
import online.superh.boot.mapstruct.service.SysUserService;
import online.superh.boot.mapstruct.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 22497
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2022-12-21 11:50:59
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




