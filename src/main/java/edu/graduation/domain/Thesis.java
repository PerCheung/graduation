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
 * @since 2022-04-30 23:53:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Thesis implements Serializable {
    private static final long serialVersionUID = 929765061184069150L;
    /**
     * 学生学号
     */
    @TableId(value = "student_id", type = IdType.AUTO)
    private String studentId;

    /**
     * 毕业论文文件名称
     */
    @TableField(value = "thesis_name")
    private String thesisName;

    /**
     * 状态（0表示未审核，1表示通过，2表示不通过）
     */
    @TableField(value = "state")
    private Integer state;

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
     * 论文文件原始名称
     */
    @TableField(value = "thesis_original")
    private String thesisOriginal;

    /**
     * 是否分配答辩
     */
    @TableField(value = "reply")
    private Integer reply;

    /**
     * 得分
     */
    @TableField(value = "score")
    private Integer score;
}
