package com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackages            = "com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.schema2.repository",
  entityManagerFactoryRef = "schema2EntityManagerFactoryBean",
  transactionManagerRef   = "schema2TransactionManager"
)
public class Schema2Config {

  //=========================================================================================================
  // DATA SOURCE PROPERTIES
  //=========================================================================================================
  @Bean
  @ConfigurationProperties("schema2.spring.datasource")
  public DataSourceProperties schema2DataSourceProperties() {
    return new DataSourceProperties();
  }
  
  //=========================================================================================================
  // DATA SOURCE
  //=========================================================================================================
  @Bean
  @Primary
  public DataSource schema2DataSource() {
    return schema2DataSourceProperties().initializeDataSourceBuilder().build();
  }
  
  //=========================================================================================================
  // ENTITY MANAGER FACTORY BEAN
  //=========================================================================================================
  @Bean
  LocalContainerEntityManagerFactoryBean schema2EntityManagerFactoryBean (
    EntityManagerFactoryBuilder entityManagerFactoryBuilder,
    DataSource                  dataSource
  ) {
    return entityManagerFactoryBuilder
          .dataSource(dataSource)
          .packages("com.ivoronline.diffentitiesindiffschemas.schema2.entity")
          .build();
  }
  
  //=========================================================================================================
  // SCHEMA 2 TRANSACTION MANAGER
  //=========================================================================================================
  @Bean
  PlatformTransactionManager schema2TransactionManager(@Qualifier("schema2EntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb) {
    return new JpaTransactionManager(emfb.getObject());
  }
  
}
