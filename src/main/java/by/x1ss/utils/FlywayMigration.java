package by.x1ss.utils;

import org.flywaydb.core.Flyway;


public class FlywayMigration {
    public static void flywayStartMigration() {
        Flyway flyway = Flyway.configure().
                dataSource("jdbc:postgresql://localhost:5432/MeetUp", "postgres", "6321")
                .load();
        flyway.migrate();
    }
}
