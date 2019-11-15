package mybatis.autoconfig;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import mybatis.MybatisPlusCodeGenerator;
import mybatis.MybatisPlusGeneratorProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(MybatisPlusGeneratorProperties.class)
@ConditionalOnClass({AutoGenerator.class, PaginationInterceptor.class})
public class MybatisPlusConfig {

    /**
     * 代码生成器
     */
    @Bean
    @ConditionalOnClass({AutoGenerator.class})
    public MybatisPlusCodeGenerator mybatisPlusCodeGenerator(MybatisPlusGeneratorProperties mybatisPlusGeneratorProperties){
        return new MybatisPlusCodeGenerator(mybatisPlusGeneratorProperties);
    }

    /**
     * 分页插件
     */
    @Bean
    @ConditionalOnClass({PaginationInterceptor.class})
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
        return paginationInterceptor;
    }

}
