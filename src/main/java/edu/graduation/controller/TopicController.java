package edu.graduation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.graduation.domain.Student;
import edu.graduation.domain.Topic;
import edu.graduation.service.StudentService;
import edu.graduation.service.TopicService;
import edu.graduation.util.R;
import edu.graduation.vo.StudentTopicVO;
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
@CrossOrigin(origins = "*")
public class TopicController {

    /**
     * 服务对象
     */
    @Resource
    private TopicService topicService;

    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R page(@RequestParam int current, @RequestParam int size) {
        Page<Topic> page = new Page<>(current, size);
        return R.ok().setData(this.topicService.page(page));
    }

    /**
     * 分页查询当前教师的所有数据
     */
    @GetMapping("teacher")
    public R pageTeacher(@RequestParam int current, @RequestParam int size, @RequestParam String teacherId) {
        Page<Topic> page = new Page<>(current, size);
        QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id", teacherId);
        return R.ok().setData(this.topicService.page(page, queryWrapper));
    }

    /**
     * 分页查询未审核数据
     */
    @GetMapping("Reviewed")
    public R pageR(@RequestParam int current, @RequestParam int size) {
        Page<Topic> page = new Page<>(current, size);
        QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", 1);
        return R.ok().setData(this.topicService.page(page, queryWrapper));
    }

    /**
     * 分页查询未审核数据
     */
    @GetMapping("NotReviewed")
    public R pageNotR(@RequestParam int current, @RequestParam int size) {
        Page<Topic> page = new Page<>(current, size);
        QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", 0);
        return R.ok().setData(this.topicService.page(page, queryWrapper));
    }

    /**
     * 分页查询未通过数据
     */
    @GetMapping("NO")
    public R pageNO(@RequestParam int current, @RequestParam int size) {
        Page<Topic> page = new Page<>(current, size);
        QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", 2);
        return R.ok().setData(this.topicService.page(page, queryWrapper));
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
     * 将学生，课题，教师绑定
     */
    @PutMapping("student")
    public R updateStudentTopic(@RequestBody StudentTopicVO studentTopicVO) {
        //为学生绑定教师和课题
        Student student = this.studentService.getById(studentTopicVO.getStudentId());
        student.setTopicId(studentTopicVO.getTopicId());
        student.setTeacherId(studentTopicVO.getTeacherId());
        //为课题绑定学生
        Topic topic = this.topicService.getById(studentTopicVO.getTopicId());
        topic.setStudentId(studentTopicVO.getStudentId());
        return R.ok().setData(this.topicService.updateById(topic) && this.studentService.updateById(student));
    }

    /**
     * 单条/批量删除数据
     */
    @DeleteMapping
    public R delete(@RequestParam List<Integer> id) {
        return R.ok().setData(this.topicService.removeByIds(id));
    }
}
