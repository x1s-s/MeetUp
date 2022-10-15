package by.x1ss;

import by.x1ss.utils.FlyWayMigration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args).start();
        FlyWayMigration.flywayStartMigration();
    }
}
