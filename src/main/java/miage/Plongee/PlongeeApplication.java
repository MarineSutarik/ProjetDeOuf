package miage.Plongee;

import controllers.CoursController;
import controllers.MembresController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"controllers"})
@EntityScan("domain")
@EnableJpaRepositories("domain.repo")
public class PlongeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlongeeApplication.class, args);
	}
}
