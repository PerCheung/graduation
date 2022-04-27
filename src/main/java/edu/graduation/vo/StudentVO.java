package edu.graduation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Peter Cheung
 * @date 2022/4/27 23:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO implements Serializable {
    private static final long serialVersionUID = -69123453771131210L;
    /**
     * 学生学号
     */
    private String studentId;

    /**
     * 学生密码
     */
    private String password;

    /**
     * 学生旧密码
     */
    private String oldPassword;

    /**
     * 学生新密码
     */
    private String newPassword;

    /**
     * 角色（管理员为0，教师为1，学生为2）
     */
    private Integer role;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生院系
     */
    private String studentCollege;

    /**
     * 学生专业
     */
    private String studentMajor;

    /**
     * 性别
     */
    private String sex;

    /**
     * 学生电话
     */
    private String studentPhone;

    /**
     * 学生邮箱
     */
    private String studentEmail;

    /**
     * 教师工号
     */
    private String teacherId;

    /**
     * 课题编号
     */
    private Integer topicId;
}
