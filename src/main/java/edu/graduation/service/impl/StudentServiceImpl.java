package edu.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.graduation.domain.Student;
import edu.graduation.mapper.StudentMapper;
import edu.graduation.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * 学生(Student)表服务实现类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
