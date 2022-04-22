package edu.graduation.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务书(Assignment)实体类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment implements Serializable {
    private static final long serialVersionUID = 816676429274631153L;
    /**
     * 任务书编号
     */
    @TableId(value = "assignment_id", type = IdType.AUTO)
    private Integer assignmentId;

    /**
     * 任务书主题
     */
    @TableField(value = "assignment_main")
    private String assignmentMain;

    /**
     * 任务书目标
     */
    @TableField(value = "assignment_target")
    private String assignmentTarget;

    /**
     * 任务书规定毕设提交时间
     */
    @TableField(value = "assignment_time")
    private String assignmentTime;

    /**
     * 任务书文件名称
     */
    @TableField(value = "assignment_name")
    private String assignmentName;

    /**
     * 任务书文件位置
     */
    @TableField(value = "assignment_path")
    private String assignmentPath;

    /**
     * 状态（0表示未审核，1表示通过，2表示不通过）
     */
    @TableField(value = "state")
    private Integer state;

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
