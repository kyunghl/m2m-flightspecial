package com.amazon.proserve.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = { "com.amazon.proserve.infrastructure.customer.persistence.jpa" })
@EnableJpaRepositories(basePackages = { "com.amazon.proserve.infrastructure.customer.persistence" })
public class DataSourceConfiguration {
}
