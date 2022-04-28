package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Student;
import edu.graduation.service.StudentService;
import edu.graduation.util.MD5Util;
import edu.graduation.util.R;
import edu.graduation.vo.StudentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 学生(Student)表控制层
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@RestController
@RequestMapping("student")
@CrossOrigin(origins = "*")
public class StudentController {

    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Student> page = new Page<>(current, size);
        return R.ok().setData(this.studentService.page(page));
    }

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok().setData(this.studentService.getById(id));
    }

    /**
     * 新增数据
     */
    @PostMapping
    public R save(@RequestBody Student student) {
        return R.ok().setData(this.studentService.save(student));
    }

    /**
     * 登录
     */
    @PostMapping("login")
    public R login(@RequestBody Student student) {
        Student sqlStudent;
        try {
            sqlStudent = this.studentService.getById(student.getStudentId());
            if (!sqlStudent.getPassword().equals(MD5Util.toMd5(student.getPassword()))) {
                return R.fail().setData("密码错误");
            }
        } catch (NullPointerException e) {
            return R.fail().setData("用户名不存在");
        }
        return R.ok().setData("登录成功");
    }

    /**
     * 注册学生
     */
    @PostMapping("/reg")
    public R reg(@RequestBody Student student) {
        student.setPassword(MD5Util.toMd5(student.getPassword()));
        try {
            return R.ok().setData(this.studentService.save(student));
        } catch (Exception e) {
            return R.exp().setData("添加失败，请记得增加学生院系信息");
        }
    }

    /**
     * 重置密码
     */
    @PutMapping("/initialization")
    public R initialization(@RequestBody Student student) {
        student.setPassword(MD5Util.toMd5(student.getStudentId()));
        return R.ok().setData(this.studentService.updateById(student));
    }

    /**
     * 修改密码
     */
    @PutMapping("/change")
    public R update(@RequestBody StudentVO studentVO) {
        Student sqlUser = this.studentService.getById(studentVO.getStudentId());
        if (!sqlUser.getPassword().equals(MD5Util.toMd5(studentVO.getOldPassword())))
            return R.fail().setData("原密码错误");
        Student student = new Student();
        BeanUtils.copyProperties(studentVO, student);
        student.setPassword(MD5Util.toMd5(studentVO.getNewPassword()));
        return R.ok().setData(this.studentService.updateById(student));
    }

    /**
     * 修改数据
     */
    @PutMapping
    public R updateById(@RequestBody Student student) {
        return R.ok().setData(this.studentService.updateById(student));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok().setData(this.studentService.removeByIds(id));
    }
}
