package edu.graduation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Peter Cheung
 * @date 2022/4/29 22:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTopicVO implements Serializable {
    private static final long serialVersionUID = 912261321345107521L;

    /**
     * 学生学号
     */
    private String studentId;

    /**
     * 教师工号
     */
    private String teacherId;

    /**
     * 课题编号
     */
    private Integer topicId;
}
