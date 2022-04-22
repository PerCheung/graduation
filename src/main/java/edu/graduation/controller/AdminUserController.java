package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.AdminUser;
import edu.graduation.service.AdminUserService;
import edu.graduation.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 管理员(AdminUser)表控制层
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@RestController
@RequestMapping("adminUser")
public class AdminUserController {

    /**
     * 服务对象
     */
    @Resource
    private AdminUserService adminUserService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<AdminUser> page = new Page<>(current, size);
        return R.ok().setData(this.adminUserService.page(page));
    }


    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok().setData(this.adminUserService.getById(id));
    }

    /**
     * 新增数据
     */
    @PostMapping
    public R save(@RequestBody AdminUser adminUser) {
        return R.ok().setData(this.adminUserService.save(adminUser));
    }

    /**
     * 修改数据
     */
    @PutMapping
    public R updateById(@RequestBody AdminUser adminUser) {
        return R.ok().setData(this.adminUserService.updateById(adminUser));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok().setData(this.adminUserService.removeByIds(id));
    }
}
