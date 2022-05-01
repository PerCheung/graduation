package edu.graduation.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Documentation;
import edu.graduation.service.DocumentationService;
import edu.graduation.util.MinIoUtil;
import edu.graduation.util.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;

/**
 * 过程文档(Documentation)表控制层
 *
 * @author Peter Cheung
 * @since 2022-05-01 23:38:36
 */
@RestController
@RequestMapping("documentation")
@CrossOrigin(origins = "*")
public class DocumentationController {

    /**
     * 服务对象
     */
    @Resource
    private DocumentationService documentationService;

    @Resource
    private MinIoUtil minIoUtil;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Documentation> page = new Page<>(current, size);
        return R.ok().setData(this.documentationService.page(page));
    }

    /**
     * 下载过程文档文件
     */
    @GetMapping("download/{filename}")
    public void download(@PathVariable String filename, HttpServletResponse res) {
        minIoUtil.download(filename, "documentation", res);
    }

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok().setData(this.documentationService.getById(id));
    }

    /**
     * 新增数据
     */
    @PostMapping
    public R save(Documentation documentation, MultipartFile file) {
        Documentation exist = this.documentationService.getById(documentation.getStudentId());
        //获取上传文件的名称
        String documentationOriginal;
        String documentationName;
        try {
            documentationOriginal = file.getOriginalFilename();
            documentationName = minIoUtil.upload(file, "documentation");
        } catch (Exception e) {
            return R.exp().setData("文件上传失败");
        }
        documentation.setDocumentationName(documentationName);
        documentation.setDocumentationOriginal(documentationOriginal);
        if (exist == null) {
            R.ok().setData(this.documentationService.save(documentation));
        }
        return R.ok().setData(this.documentationService.updateById(documentation));
    }

    /**
     * 修改数据
     */
    @PutMapping
    public R updateById(@RequestBody Documentation documentation) {
        return R.ok().setData(this.documentationService.updateById(documentation));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Long> id) {
        return R.ok().setData(this.documentationService.removeByIds(id));
    }
}
