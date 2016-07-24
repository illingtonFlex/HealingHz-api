package HealingHz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HealingHzApiApplication
{
	public static void main(String[] args)
    {
		SpringApplication.run(HealingHzApiApplication.class, args);
	}
}
