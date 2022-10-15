package by.x1ss.utils;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;

@Slf4j
public class FlyWayMigration {
    public static void flywayStartMigration(){
        var flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/MeetUp","postgres","6321")
                .locations("classpath:/db/migration")
                .load();
        flyway.migrate();
    }
}
