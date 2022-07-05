package com.icss.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


//Spring的配置类
@Configuration
@ComponentScan(value = "com.icss.service")
@PropertySource("classpath:dbconfig123.properties")
//@PropertySource("classpath:dbconfig.properties")
@EnableTransactionManagement //启用事务管理器类
@MapperScan(basePackages = "com.icss.mapper") //扫描Mybatis 的mapper报下的接口
public class RootConfig {


    //创建和配置数据源
    @Bean("dataSource")
    public DataSource dataSource(
            @Value("${jdbc.driverClass}") String driverClass,
            @Value("${jdbc.jdbcUrl}") String jdbcUrl,
            @Value("${jdbc.user}") String user,
            @Value("${jdbc.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        try {
            dataSource.setDriverClassName(driverClass);
            dataSource.setUrl(jdbcUrl);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    //创建事务管理器 -AOP
    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //配置MyBatis的Bean工厂
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource, @Value("${mybatis.mapper.location}") Resource[] mapperLocations) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);

        //创建分页插件对象
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties prop  = new Properties();
        prop.setProperty("reasonable","true");
        pageInterceptor.setProperties(prop);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});

        return sqlSessionFactoryBean;
    }
}