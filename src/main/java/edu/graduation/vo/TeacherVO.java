package edu.graduation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Peter Cheung
 * @date 2022/4/27 23:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherVO implements Serializable {
    private static final long serialVersionUID = 667146133075643381L;
    /**
     * 教师工号
     */
    private String teacherId;

    /**
     * 教师密码
     */
    private String password;

    /**
     * 教师旧密码
     */
    private String oldPassword;

    /**
     * 教师新密码
     */
    private String newPassword;

    /**
     * 角色（管理员为0，教师为1，学生为2）
     */
    private Integer role;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师院系
     */
    private String teacherCollege;

    /**
     * 教师专业
     */
    private String teacherMajor;

    /**
     * 性别
     */
    private String sex;

    /**
     * 教师职称
     */
    private String teacherTitle;

    /**
     * 教师电话
     */
    private String teacherPhone;

    /**
     * 教师邮箱
     */
    private String teacherEmail;

}
