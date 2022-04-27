package edu.graduation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Peter Cheung
 * @date 2022/4/23 0:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserVO implements Serializable {
    private static final long serialVersionUID = 112261721568107521L;
    /**
     * 管理员账号
     */
    private String userId;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 管理员旧密码
     */
    private String oldPassword;

    /**
     * 管理员新密码
     */
    private String newPassword;

    /**
     * 角色（管理员为0，教师为1，学生为2）
     */
    private Integer role;

    /**
     * 管理员姓名
     */
    private String username;

    /**
     * 管理员职称
     */
    private String userTitle;

    /**
     * 注册验证码
     */
    private String verify;
}
