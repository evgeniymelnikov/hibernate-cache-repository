package com.github.evgeniymelnikov.hibernatecachetemplate.configuration;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public Statistics getHibernateStatisticsBean(@Autowired EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.unwrap(SessionFactory.class).getStatistics();
    }

    @Bean
    public MBeanExporter getMBeanExporter(@Autowired Statistics statistics) {
        MBeanExporter mBeanExporter = new MBeanExporter();
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("Hibernate:type=statistics", statistics);
        mBeanExporter.setBeans(map);
        return mBeanExporter;
    }
}
