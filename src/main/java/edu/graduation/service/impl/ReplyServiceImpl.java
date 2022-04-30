package edu.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.graduation.domain.Reply;
import edu.graduation.mapper.ReplyMapper;
import edu.graduation.service.ReplyService;
import org.springframework.stereotype.Service;

/**
 * 答辩(Reply)表服务实现类
 *
 * @author Peter Cheung
 * @since 2022-04-30 21:48:23
 */
@Service("replyService")
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {
}
