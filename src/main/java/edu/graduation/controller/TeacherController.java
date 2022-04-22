package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Teacher;
import edu.graduation.service.TeacherService;
import edu.graduation.util.R;
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
public class TeacherController {

    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Teacher> page = new Page<>(current, size);
        return R.ok().setData(this.teacherService.page(page));
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
