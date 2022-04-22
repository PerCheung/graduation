package edu.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.graduation.domain.Assignment;
import edu.graduation.mapper.AssignmentMapper;
import edu.graduation.service.AssignmentService;
import org.springframework.stereotype.Service;

/**
 * 任务书(Assignment)表服务实现类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@Service("assignmentService")
public class AssignmentServiceImpl extends ServiceImpl<AssignmentMapper, Assignment> implements AssignmentService {
}
