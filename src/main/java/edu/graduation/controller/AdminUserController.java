package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.AdminUser;
import edu.graduation.service.AdminUserService;
import edu.graduation.util.MD5Util;
import edu.graduation.util.R;
import edu.graduation.vo.AdminUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
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
@CrossOrigin(origins = "*")
public class AdminUserController {
    /**
     * 注册验证码
     */
    @Value("${adminUser.verify}")
    private String verify;

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
     * 登录
     */
    @GetMapping("login")
    public R login(@RequestBody AdminUser adminUser) {
        AdminUser sqlUser;
        try {
            sqlUser = this.adminUserService.getById(adminUser.getUserId());
            if (!sqlUser.getPassword().equals(MD5Util.toMd5(adminUser.getPassword()))) {
                return R.fail().setData("密码错误");
            }
        } catch (NullPointerException e) {
            return R.fail().setData("用户名不存在");
        }
        return R.ok().setData("登录成功");
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
    public R save(@RequestBody AdminUserVO adminUserVO) {
        AdminUser adminUser;
        try {
            if (!adminUserVO.getVerify().equals(verify)) {
                return R.fail().setData("验证码错误");
            }
            adminUser = new AdminUser();
            BeanUtils.copyProperties(adminUserVO, adminUser);
            adminUser.setPassword(MD5Util.toMd5(adminUser.getPassword()));
        } catch (NullPointerException e) {
            return R.fail().setData("未输入验证码");
        }
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
