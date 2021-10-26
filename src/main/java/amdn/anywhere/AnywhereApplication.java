package amdn.anywhere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AnywhereApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnywhereApplication.class, args);
	}

}
