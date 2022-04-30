package edu.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Reply;
import edu.graduation.service.ReplyService;
import edu.graduation.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 答辩(Reply)表控制层
 *
 * @author Peter Cheung
 * @since 2022-04-30 21:48:23
 */
@RestController
@RequestMapping("reply")
@CrossOrigin(origins = "*")
public class ReplyController {

    /**
     * 服务对象
     */
    @Resource
    private ReplyService replyService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Reply> page = new Page<>(current, size);
        return R.ok().setData(this.replyService.page(page));
    }

    /**
     * 分页查询当前教师所有数据
     */
    @GetMapping("teacher")
    public R page(@RequestParam int current, @RequestParam int size, @RequestParam String teacherId) {
        Page<Reply> page = new Page<>(current, size);
        QueryWrapper<Reply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id", teacherId);
        queryWrapper.eq("score", 0);
        return R.ok().setData(this.replyService.page(page, queryWrapper));
    }

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok().setData(this.replyService.getById(id));
    }

    /**
     * 新增数据
     */
    @PostMapping
    public R save(@RequestBody Reply reply) {
        return R.ok().setData(this.replyService.save(reply));
    }

    /**
     * 修改数据
     */
    @PutMapping
    public R updateById(@RequestBody Reply reply) {
        return R.ok().setData(this.replyService.updateById(reply));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok().setData(this.replyService.removeByIds(id));
    }
}
