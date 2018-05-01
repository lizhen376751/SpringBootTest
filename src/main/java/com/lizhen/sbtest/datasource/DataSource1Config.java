//package com.lizhen.sbtest.datasource;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//// 声明当前类是个配置类,相当于一个Spring配置的xml文件
//@Configuration
////扫包的时候扫这个包下面的
//@MapperScan(basePackages = "com.lizhen.sbtest.test001", sqlSessionFactoryRef = "test001SqlSessionFactory")
//public class DataSource1Config {
//
//    //创建数据源，读取test001的配置文件，并存放在spring容器里面
//    @Bean(name = "test001DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.test001")
//    //@Primary 告诉spring 在犹豫的时候优先选择哪一个具体的实现
//    @Primary
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    //创建回话工厂，并放在spring容器里面
//    @Bean(name = "test001SqlSessionFactory")
//    @Primary
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test001DataSource") DataSource dataSource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        //mybatis写配置文件
////        bean.setMapperLocations(
////                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
//        return bean.getObject();
//    }
//
//
//    /**
//     * 创建事物管理类，并存放在spring容器里面
//     *
//     * @param dataSource
//     * @return
//     */
//    @Bean(name = "test001TransactionManager")
//    @Primary
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test001DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    /**
//     * 创建模板
//     *
//     * @param sqlSessionFactory
//     * @return
//     * @throws Exception
//     */
//    @Bean(name = "test001SqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate testSqlSessionTemplate(
//            @Qualifier("test001SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
