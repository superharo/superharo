package online.superh.boot.mapstruct.vo;

import lombok.Data;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2022-12-19 18:25
 */
@Data
public class UserVO {

    /** 用户编号 **/
    private Integer id;
    /** 用户名 **/
    private String username;
    /** 密码 **/
    private String password;

}
