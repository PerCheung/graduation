package edu.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.graduation.domain.Documentation;
import edu.graduation.mapper.DocumentationMapper;
import edu.graduation.service.DocumentationService;
import org.springframework.stereotype.Service;

/**
 * 过程文档(Documentation)表服务实现类
 *
 * @author Peter Cheung
 * @since 2022-05-01 23:38:36
 */
@Service("documentationService")
public class DocumentationServiceImpl extends ServiceImpl<DocumentationMapper, Documentation> implements DocumentationService {
}
