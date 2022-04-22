package edu.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.graduation.domain.Topic;
import edu.graduation.mapper.TopicMapper;
import edu.graduation.service.TopicService;
import org.springframework.stereotype.Service;

/**
 * 课题(Topic)表服务实现类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:49
 */
@Service("topicService")
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {
}
