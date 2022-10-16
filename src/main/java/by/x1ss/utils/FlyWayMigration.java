package by.x1ss.utils;

import org.flywaydb.core.Flyway;


public class FlyWayMigration {
    public static void flywayStartMigration() {
        Flyway flyway = Flyway.configure().
                dataSource("jdbc:postgresql://postgres:5432/MeetUp", "postgres", "6321")
                .load();
        flyway.migrate();
    }
}
