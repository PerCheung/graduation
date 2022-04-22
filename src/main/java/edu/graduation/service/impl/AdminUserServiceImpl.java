package edu.graduation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.graduation.domain.AdminUser;
import edu.graduation.mapper.AdminUserMapper;
import edu.graduation.service.AdminUserService;
import org.springframework.stereotype.Service;

/**
 * 管理员(AdminUser)表服务实现类
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:58:48
 */
@Service("adminUserService")
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
}
