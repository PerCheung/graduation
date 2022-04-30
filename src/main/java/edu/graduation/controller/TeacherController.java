package edu.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Student;
import edu.graduation.domain.Teacher;
import edu.graduation.service.StudentService;
import edu.graduation.service.TeacherService;
import edu.graduation.util.MD5Util;
import edu.graduation.util.R;
import edu.graduation.vo.TeacherVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 教师(Teacher)表控制层
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:49
 */
@RestController
@RequestMapping("teacher")
@CrossOrigin(origins = "*")
public class TeacherController {

    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    @Resource
    private StudentService studentService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Teacher> page = new Page<>(current, size);
        return R.ok().setData(this.teacherService.page(page));
    }

    /**
     * 查询不是当前学号的老师
     */
    @GetMapping("/noStudent/{studentId}")
    public R getTeacher(@PathVariable String studentId) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        Student student = studentService.getById(studentId);
        queryWrapper.ne("teacher_id", student.getTeacherId());
        return R.ok().setData(this.teacherService.list(queryWrapper));
    }

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok().setData(this.teacherService.getById(id));
    }

    /**
     * 新增数据
     */
    @PostMapping
    public R save(@RequestBody Teacher teacher) {
        return R.ok().setData(this.teacherService.save(teacher));
    }

    /**
     * 登录
     */
    @PostMapping("login")
    public R login(@RequestBody Teacher teacher) {
        Teacher sqlTeacher;
        try {
            sqlTeacher = this.teacherService.getById(teacher.getTeacherId());
            if (!sqlTeacher.getPassword().equals(MD5Util.toMd5(teacher.getPassword()))) {
                return R.fail().setData("密码错误");
            }
        } catch (NullPointerException e) {
            return R.fail().setData("用户名不存在");
        }
        return R.ok().setData("登录成功");
    }

    /**
     * 注册教师
     */
    @PostMapping("/reg")
    public R reg(@RequestBody Teacher teacher) {
        teacher.setPassword(MD5Util.toMd5(teacher.getPassword()));
        try {
            return R.ok().setData(this.teacherService.save(teacher));
        } catch (Exception e) {
            return R.exp().setData("添加失败，请记得增加教师院系信息");
        }
    }

    /**
     * 重置密码
     */
    @PutMapping("/initialization")
    public R initialization(@RequestBody Teacher teacher) {
        teacher.setPassword(MD5Util.toMd5(teacher.getTeacherId()));
        return R.ok().setData(this.teacherService.updateById(teacher));
    }

    /**
     * 修改密码
     */
    @PutMapping("/change")
    public R update(@RequestBody TeacherVO teacherVO) {
        Teacher sqlUser = this.teacherService.getById(teacherVO.getTeacherId());
        if (!sqlUser.getPassword().equals(MD5Util.toMd5(teacherVO.getOldPassword())))
            return R.fail().setData("原密码错误");
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherVO, teacher);
        teacher.setPassword(MD5Util.toMd5(teacherVO.getNewPassword()));
        return R.ok().setData(this.teacherService.updateById(teacher));
    }

    /**
     * 修改数据
     */
    @PutMapping
    public R updateById(@RequestBody Teacher teacher) {
        return R.ok().setData(this.teacherService.updateById(teacher));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok().setData(this.teacherService.removeByIds(id));
    }
}
