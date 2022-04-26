package edu.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.graduation.domain.Announcement;
import edu.graduation.mapper.AnnouncementMapper;
import edu.graduation.service.AnnouncementService;
import org.springframework.stereotype.Service;

/**
 * 公告(Announcement)表服务实现类
 *
 * @author Peter Cheung
 * @since 2022-04-25 14:55:18
 */
@Service("announcementService")
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {
}
