package edu.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.graduation.domain.Thesis;
import edu.graduation.mapper.ThesisMapper;
import edu.graduation.service.ThesisService;
import org.springframework.stereotype.Service;

/**
 * 毕业论文(Thesis)表服务实现类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:49
 */
@Service("thesisService")
public class ThesisServiceImpl extends ServiceImpl<ThesisMapper, Thesis> implements ThesisService {
}
