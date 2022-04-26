package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Announcement;
import edu.graduation.service.AnnouncementService;
import edu.graduation.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 公告(Announcement)表控制层
 *
 * @author Peter Cheung
 * @since 2022-04-25 14:55:18
 */
@RestController
@RequestMapping("announcement")
@CrossOrigin(origins = "*")
public class AnnouncementController {

    /**
     * 服务对象
     */
    @Resource
    private AnnouncementService announcementService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Announcement> page = new Page<>(current, size);
        return R.ok().setData(this.announcementService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok().setData(this.announcementService.getById(id));
    }

    /**
     * 新增数据
     */
    @PostMapping
    public R save(@RequestBody Announcement announcement) {
        return R.ok().setData(this.announcementService.save(announcement));
    }

    /**
     * 修改数据
     */
    @PutMapping
    public R updateById(@RequestBody Announcement announcement) {
        return R.ok().setData(this.announcementService.updateById(announcement));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok().setData(this.announcementService.removeByIds(id));
    }
}
