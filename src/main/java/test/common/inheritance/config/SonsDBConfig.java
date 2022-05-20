package test.common.inheritance.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "test.common.inheritance.repository.sons",
        entityManagerFactoryRef = "sonsEntityManagerFactory",
        transactionManagerRef = "sonsTransactionManager")
public class SonsDBConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.sons.datasource")
    public DataSource sonsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sonsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sonsEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("sonsDataSource") DataSource sonsDataSource) {
        return builder
                .dataSource(sonsDataSource)
                .packages("test.common.inheritance.entity.sons")
                .persistenceUnit("sonsPU")
                .build();
    }

    @Bean(name = "sonsTransactionManager")
    public PlatformTransactionManager sonsTransactionManager(
            @Qualifier("sonsEntityManagerFactory") EntityManagerFactory sonsEntityManagerFactory) {
        return new JpaTransactionManager(sonsEntityManagerFactory);
    }
}

