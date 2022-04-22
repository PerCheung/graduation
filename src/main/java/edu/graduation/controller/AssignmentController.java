package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Assignment;
import edu.graduation.service.AssignmentService;
import edu.graduation.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 任务书(Assignment)表控制层
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@RestController
@RequestMapping("assignment")
public class AssignmentController {

    /**
     * 服务对象
     */
    @Resource
    private AssignmentService assignmentService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Assignment> page = new Page<>(current, size);
        return R.ok().setData(this.assignmentService.page(page));
    }

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok().setData(this.assignmentService.getById(id));
    }

    /**
     * 新增数据
     */
    @PostMapping
    public R save(@RequestBody Assignment assignment) {
        return R.ok().setData(this.assignmentService.save(assignment));
    }

    /**
     * 修改数据
     */
    @PutMapping
    public R updateById(@RequestBody Assignment assignment) {
        return R.ok().setData(this.assignmentService.updateById(assignment));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok().setData(this.assignmentService.removeByIds(id));
    }
}
