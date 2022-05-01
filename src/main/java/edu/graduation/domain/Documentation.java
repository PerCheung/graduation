package edu.graduation.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 过程文档(Documentation)实体类
 *
 * @author Peter Cheung
 * @since 2022-05-01 23:38:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documentation implements Serializable {
    private static final long serialVersionUID = 962769110556108396L;
    /**
     * 学生学号
     */
    @TableId(value = "student_id")
    private String studentId;

    /**
     * 过程文档文件原始名称
     */
    @TableField(value = "documentation_original")
    private String documentationOriginal;

    /**
     * 过程文档文件名称
     */
    @TableField(value = "documentation_name")
    private String documentationName;

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
