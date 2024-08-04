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
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
  basePackages            = "com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.schema1.repository",
  entityManagerFactoryRef = "schema1EntityManagerFactoryBean",
  transactionManagerRef   = "schema1TransactionManager"
)
public class Schema1Config {

  //=========================================================================================================
  // DATA SOURCE PROPERTIES
  //=========================================================================================================
  @Bean
  @ConfigurationProperties("schema1.spring.datasource")
  public DataSourceProperties schema1DataSourceProperties() {
    return new DataSourceProperties();
  }
  
  //=========================================================================================================
  // DATA SOURCE
  //=========================================================================================================
  @Bean
  @Primary
  public DataSource schema1DataSource() {
    return schema1DataSourceProperties().initializeDataSourceBuilder().build();
  }
  
  //=========================================================================================================
  // ENTITY MANAGER FACTORY BEAN
  //=========================================================================================================
  @Bean
  LocalContainerEntityManagerFactoryBean schema1EntityManagerFactoryBean (
    EntityManagerFactoryBuilder entityManagerFactoryBuilder,
    DataSource                  dataSource
  ) {
    return entityManagerFactoryBuilder
          .dataSource(dataSource)
          .packages("com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.schema1.entity")
          .build();
  }

  //=========================================================================================================
  // SCHEMA 1 TRANSACTION MANAGER
  //=========================================================================================================
  @Bean
  PlatformTransactionManager schema1TransactionManager(@Qualifier("schema1EntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb) {
    return new JpaTransactionManager(emfb.getObject());
  }

}
