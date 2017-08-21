package org.sprintdragon.opensource.shardingjdbc.config;//package org.sprintdragon.experiment.shardingjdbc.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.jd.pop.task.performance.node.watcher.InstanceWatcher;
//import com.jd.pop.task.performance.shared.arbitrate.config.ArbitrateConfig;
//import com.jd.pop.task.performance.shared.arbitrate.config.ArbitrateConfigRegistry;
//import com.jd.pop.task.performance.shared.arbitrate.event.InstanceOperateEvent;
//import com.jd.pop.task.performance.shared.arbitrate.event.UnitOperateEvent;
//import com.jd.pop.task.performance.shared.model.DbInfo;
//import com.jd.pop.task.performance.shared.model.Instance;
//import com.jd.pop.task.performance.shared.model.ServerInfo;
//import com.jd.pop.task.performance.shared.model.Unit;
//import com.jd.pop.task.performance.shared.model.enums.MsType;
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * Created by wangdi on 17-2-21.
// */
//@Configuration
//@EnableJpaRepositories(basePackages = "com.jd.pop.task.performance.node.biz.repository")
//@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
//@Slf4j
//public class NodeSourceInitConfig implements InitializingBean {
//
//    private static final String DATABASE_DRIVER = "db.driver";
//    private static final String PACKAGES_TO_SCAN = "packages.to.scan";
//    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
//    private static final String HIBERNATE_SHOW_SQL = "hibernate.show.sql";
//
//    @Resource
//    private Environment env;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        try {
//            Unit unit = ArbitrateConfigRegistry.getConfig().currentUnit();
//            DruidDataSource source = new DruidDataSource();
//            source.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER));
//
//            DbInfo dbInfo = unit.getDbInfo();
//            source.setUrl(dbInfo.getUrl());
//            source.setValidationQuery("select 4 from dual");
//            source.setTestWhileIdle(true);
//            source.setUsername(dbInfo.getName());
//            source.setPassword(dbInfo.getPwd());
//            return source;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setDataSource(dataSource());
//        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        factory.setPackagesToScan(env.getRequiredProperty(PACKAGES_TO_SCAN));
//        factory.setJpaProperties(hibernateProperties());
//        factory.afterPropertiesSet();
//        return factory;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return manager;
//    }
//
//    @Bean
//    public HibernateExceptionTranslator hibernateExceptionTranslator() {
//        return new HibernateExceptionTranslator();
//    }
//
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
//        properties.put(HIBERNATE_SHOW_SQL, env.getRequiredProperty(HIBERNATE_SHOW_SQL));
//        return properties;
//    }
//
//}
