package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Student;
import edu.graduation.service.StudentService;
import edu.graduation.util.R;
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
