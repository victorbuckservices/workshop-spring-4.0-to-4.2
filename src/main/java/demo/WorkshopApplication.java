package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan
@EnableCaching
@EnableAsync
public class WorkshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkshopApplication.class, args);
    }

}
