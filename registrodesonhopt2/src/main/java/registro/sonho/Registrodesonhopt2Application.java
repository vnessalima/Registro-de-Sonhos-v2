package registro.sonho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("registro.sonho.registrodesonhopt2")
@EntityScan(basePackages = "registro.sonho.registrodesonhopt2.models")

public class Registrodesonhopt2Application {

	public static void main(String[] args) {
		SpringApplication.run(Registrodesonhopt2Application.class, args);
	}
}