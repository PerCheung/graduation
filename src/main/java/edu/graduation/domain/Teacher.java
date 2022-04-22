package edu.graduation.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 教师(Teacher)实体类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    private static final long serialVersionUID = 766246145075643382L;
    /**
     * 教师工号
     */
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private String teacherId;

    /**
     * 教师密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 角色（管理员为0，教师为1，学生为2）
     */
    @TableField(value = "role")
    private Integer role;

    /**
     * 教师姓名
     */
    @TableField(value = "teacher_name")
    private String teacherName;

    /**
     * 教师院系
     */
    @TableField(value = "teacher_college")
    private String teacherCollege;

    /**
     * 教师专业
     */
    @TableField(value = "teacher_major")
    private String teacherMajor;

    /**
     * 性别（1表示男，0表示女）
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 教师职称
     */
    @TableField(value = "teacher_title")
    private String teacherTitle;

    /**
     * 教师电话
     */
    @TableField(value = "teacher_phone")
    private String teacherPhone;

    /**
     * 教师邮箱
     */
    @TableField(value = "teacher_email")
    private String teacherEmail;

    /**创建时间*/
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**修改时间*/
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
