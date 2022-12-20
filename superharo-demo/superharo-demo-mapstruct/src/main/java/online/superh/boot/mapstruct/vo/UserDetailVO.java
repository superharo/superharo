package online.superh.boot.mapstruct.vo;

import lombok.Data;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2022-12-20 11:08
 */
@Data
public class UserDetailVO {

    /** 用户编号 **/
    private Integer userId;

    /** 部门编号 **/
    private Integer deptId;

    /** 部门名称 **/
    private String deptName;

}
