package edu.graduation.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 答辩(Reply)实体类
 *
 * @author Peter Cheung
 * @since 2022-04-30 21:48:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply implements Serializable {
    private static final long serialVersionUID = 282348148500761170L;
    /**
     * 学生学号
     */
    @TableId(value = "student_id")
    private String studentId;

    /**
     * 教师工号
     */
    @TableField(value = "teacher_id")
    private String teacherId;

    /**
     * 论文文件原始名称
     */
    @TableField(value = "thesis_original")
    private String thesisOriginal;

    /**
     * 毕业论文文件名称
     */
    @TableField(value = "thesis_name")
    private String thesisName;

    /**
     * 得分
     */
    @TableField(value = "score")
    private Integer score;

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
