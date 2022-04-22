package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Topic;
import edu.graduation.service.TopicService;
import edu.graduation.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 课题(Topic)表控制层
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:49
 */
@RestController
@RequestMapping("topic")
public class TopicController {

    /**
     * 服务对象
     */
    @Resource
    private TopicService topicService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Topic> page = new Page<>(current, size);
        return R.ok().setData(this.topicService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok().setData(this.topicService.getById(id));
    }

    /**
     * 新增数据
     */
    @PostMapping
    public R save(@RequestBody Topic topic) {
        return R.ok().setData(this.topicService.save(topic));
    }

    /**
     * 修改数据
     */
    @PutMapping
    public R updateById(@RequestBody Topic topic) {
        return R.ok().setData(this.topicService.updateById(topic));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok().setData(this.topicService.removeByIds(id));
    }
}
