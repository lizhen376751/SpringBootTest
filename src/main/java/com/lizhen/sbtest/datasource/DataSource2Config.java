package com.lizhen.sbtest.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

// 声明当前类是个配置类,相当于一个Spring配置的xml文件
@Configuration
//扫包的时候扫这个包下面的
@MapperScan(basePackages = "com.lizhen.sbtest.test002", sqlSessionFactoryRef = "test002SqlSessionFactory")
public class DataSource2Config {

    //创建数据源，读取test001的配置文件，并存放在spring容器里面
    @Bean(name = "test002DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test002")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    //创建回话工厂，并放在spring容器里面
    @Bean(name = "test002SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test002DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //mybatis写配置文件
//        bean.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
        return bean.getObject();
    }


    /**
     * 创建事物管理类，并存放在spring容器里面
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "test002TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test002DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建模板
     *
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "test002SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test002SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
