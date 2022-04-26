package edu.graduation.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告(Announcement)实体类
 *
 * @author Peter Cheung
 * @since 2022-04-25 14:55:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement implements Serializable {
    private static final long serialVersionUID = 669850165712210000L;
    /**
     * 毕业论文编号
     */
    @TableId(value = "announcement_id", type = IdType.AUTO)
    private Integer announcementId;

    /**
     * 公告标题
     */
    @TableField(value = "announcement_title")
    private String announcementTitle;

    /**
     * 公告内容
     */
    @TableField(value = "announcement_main")
    private String announcementMain;

    /**
     * 管理员账号
     */
    @TableField(value = "user_id")
    private String userId;

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
