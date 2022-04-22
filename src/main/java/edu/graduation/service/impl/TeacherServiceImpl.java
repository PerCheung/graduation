package edu.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.graduation.domain.Teacher;
import edu.graduation.mapper.TeacherMapper;
import edu.graduation.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * 教师(Teacher)表服务实现类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}
