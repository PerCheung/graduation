package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Thesis;
import edu.graduation.service.ThesisService;
import edu.graduation.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 毕业论文(Thesis)表控制层
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:49
 */
@RestController
@RequestMapping("thesis")
public class ThesisController {

    /**
     * 服务对象
     */
    @Resource
    private ThesisService thesisService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Thesis> page = new Page<>(current, size);
        return R.ok().setData(this.thesisService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok().setData(this.thesisService.getById(id));
    }

    /**
     * 新增数据
     */
    @PostMapping
    public R save(@RequestBody Thesis thesis) {
        return R.ok().setData(this.thesisService.save(thesis));
    }

    /**
     * 修改数据
     */
    @PutMapping
    public R updateById(@RequestBody Thesis thesis) {
        return R.ok().setData(this.thesisService.updateById(thesis));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok().setData(this.thesisService.removeByIds(id));
    }
}
