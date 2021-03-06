package miage.Plongee;

import miage.Plongee.controllers.CoursController;
import miage.Plongee.controllers.MembresController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PlongeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlongeeApplication.class, args);
	}
}
