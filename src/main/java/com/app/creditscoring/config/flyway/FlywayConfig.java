package com.app.creditscoring.config.flyway;

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

    @Value("${spring.flyway.cleanDisabled}")
    private boolean cleanDisabled;
    @Value("${spring.flyway.clean.on-start}")
    private boolean cleanOnStart;
    @Value("${spring.flyway.locations}")
    private String locations;

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations(locations)
                .cleanDisabled(cleanDisabled)
                .load();
        if (cleanOnStart) {
            flyway.clean(); // Clean the database to only have initial data
        }
        flyway.migrate(); // Re-apply the migrations
        return flyway;
    }
}