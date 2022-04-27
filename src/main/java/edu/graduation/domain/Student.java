package edu.graduation.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生(Student)实体类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -69362313761130290L;
    /**
     * 学生学号
     */
    @TableId(value = "student_id")
    private String studentId;

    /**
     * 学生密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 角色（管理员为0，教师为1，学生为2）
     */
    @TableField(value = "role")
    private Integer role;

    /**
     * 学生姓名
     */
    @TableField(value = "student_name")
    private String studentName;

    /**
     * 学生院系
     */
    @TableField(value = "student_college")
    private String studentCollege;

    /**
     * 学生专业
     */
    @TableField(value = "student_major")
    private String studentMajor;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 学生电话
     */
    @TableField(value = "student_phone")
    private String studentPhone;

    /**
     * 学生邮箱
     */
    @TableField(value = "student_email")
    private String studentEmail;

    /**
     * 教师工号
     */
    @TableField(value = "teacher_id")
    private String teacherId;

    /**
     * 课题编号
     */
    @TableField(value = "topic_id")
    private Integer topicId;

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
