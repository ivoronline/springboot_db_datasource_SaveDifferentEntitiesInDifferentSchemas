package com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.config;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import java.util.HashMap;

@Configuration
public class MyDatabaseConfig {
  
  //=========================================================================================================
  // ENTITY MANAGER FACTORY BUILDER
  //=========================================================================================================
  @Bean
  public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
     return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
  }

}
