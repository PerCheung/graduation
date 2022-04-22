package edu.graduation.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员(AdminUser)实体类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUser implements Serializable {
    private static final long serialVersionUID = 913259721568187521L;
    /**
     * 管理员账号
     */
    @TableId(value = "user_id")
    private String userId;

    /**
     * 管理员密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 角色（管理员为0，教师为1，学生为2）
     */
    @TableField(value = "role")
    private Integer role;

    /**
     * 管理员姓名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 管理员职称
     */
    @TableField(value = "user_title")
    private String userTitle;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;
}
