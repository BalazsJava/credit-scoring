package com.app.creditscoring.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FlywayCleanMigrateRunner implements ApplicationRunner {

    private final Flyway flyway;

    @Value("${spring.flyway.clean.on-start}")
    private boolean cleanOnStart;

    public FlywayCleanMigrateRunner(Flyway flyway) {
        this.flyway = flyway;
    }

    @Override
    public void run(ApplicationArguments args$) {
        if (cleanOnStart) {
            flyway.clean();
        }
        flyway.migrate();
    }

}