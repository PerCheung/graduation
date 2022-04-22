package edu.graduation.interceptor;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis-Plus 3.5.1 拦截器
 *
 * @author Peter Cheung
 * @since 2022-04-22 22:57:43
 */
@Configuration
public class MybatisPlusPageInterceptor {
    /**
     * 新版分页插件设置
     */
    @Bean
    public MybatisPlusInterceptor getPaginationInnerInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
