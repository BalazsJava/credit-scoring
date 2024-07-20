package com.app.creditscoring.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${spring.flyway.clean.on-start}")
    private boolean cleanOnStart;

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .cleanDisabled(false)
                .load();
        if (cleanOnStart) {
            flyway.clean(); // Clean the database to only have initial data
        }
        flyway.migrate(); // Re-apply the migrations
        return flyway;
    }
}