package edu.graduation.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 毕业论文(Thesis)实体类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Thesis implements Serializable {
    private static final long serialVersionUID = 682213029799425205L;
    /**
     * 毕业论文编号
     */
    @TableId(value = "thesis_id", type = IdType.AUTO)
    private Integer thesisId;

    /**
     * 毕业论文文件名称
     */
    @TableField(value = "thesis_name")
    private String thesisName;

    /**
     * 毕业论文文件位置
     */
    @TableField(value = "thesis_path")
    private String thesisPath;

    /**
     * 状态（0表示未审核，1表示通过，2表示不通过）
     */
    @TableField(value = "state")
    private Integer state;

    /**
     * 学生学号
     */
    @TableField(value = "student_id")
    private String studentId;

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
