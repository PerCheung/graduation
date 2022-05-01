package edu.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Thesis;
import edu.graduation.service.ThesisService;
import edu.graduation.util.MinIoUtil;
import edu.graduation.util.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 毕业论文(Thesis)表控制层
 *
 * @author Peter Cheung
 * @since 2022-04-30 18:17:16
 */
@RestController
@RequestMapping("thesis")
@CrossOrigin(origins = "*")
public class ThesisController {

    /**
     * 服务对象
     */
    @Resource
    private ThesisService thesisService;

    @Resource
    private MinIoUtil minIoUtil;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Thesis> page = new Page<>(current, size);
        return R.ok().setData(this.thesisService.page(page));
    }

    /**
     * 分页查询已审核数据
     */
    @GetMapping("Reviewed")
    public R pageR(@RequestParam int current, @RequestParam int size) {
        Page<Thesis> page = new Page<>(current, size);
        QueryWrapper<Thesis> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", 1);
        return R.ok().setData(this.thesisService.page(page, queryWrapper));
    }

    /**
     * 分页查询已审核但为分配答辩的数据
     */
    @GetMapping("Reviewed/NoR")
    public R pageRN(@RequestParam int current, @RequestParam int size) {
        Page<Thesis> page = new Page<>(current, size);
        QueryWrapper<Thesis> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", 1);
        queryWrapper.eq("reply", 0);
        return R.ok().setData(this.thesisService.page(page, queryWrapper));
    }

    /**
     * 分页查询学生自己的数据
     */
    @GetMapping("student/{id}")
    public R page(@PathVariable Serializable id) {
        List<Thesis> thesisList = new ArrayList<>();
        Thesis thesis = this.thesisService.getById(id);
        thesisList.add(thesis);
        return R.ok().setData(thesisList);
    }

    /**
     * 下载毕设文件
     */
    @GetMapping("download/{filename}")
    public void download(@PathVariable String filename, HttpServletResponse res) {
        minIoUtil.download(filename, "thesis", res);
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
    public R save(Thesis thesis, MultipartFile file) {
        Thesis exist = this.thesisService.getById(thesis.getStudentId());
        //获取上传文件的名称
        String thesisOriginal;
        String thesisName;
        try {
            thesisOriginal = file.getOriginalFilename();
            thesisName = minIoUtil.upload(file, "thesis");
        } catch (Exception e) {
            return R.exp().setData("文件上传失败");
        }
        thesis.setThesisName(thesisName);
        thesis.setThesisOriginal(thesisOriginal);
        if (exist == null) {
            R.ok().setData(this.thesisService.save(thesis));
        }
        return R.ok().setData(this.thesisService.updateById(thesis));
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
    public R delete(@RequestParam List<Integer> id) {
        return R.ok().setData(this.thesisService.removeByIds(id));
    }
}
