package edu.graduation.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 课题(Topic)实体类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic implements Serializable {
    private static final long serialVersionUID = 857370840844700202L;
    /**
     * 课题编号
     */
    @TableId(value = "topic_id", type = IdType.AUTO)
    private Integer topicId;

    /**
     * 课题名称
     */
    @TableField(value = "topic_name")
    private String topicName;

    /**
     * 课题类型（0表示其他，1表示科学技术，2表示生产实践）
     */
    @TableField(value = "topic_type")
    private Integer topicType;

    /**
     * 课题来源（0表示实习，1表示院系发布）
     */
    @TableField(value = "topic_source")
    private Integer topicSource;

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
     * 学生学号
     */
    @TableField(value = "student_id")
    private String studentId;

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
