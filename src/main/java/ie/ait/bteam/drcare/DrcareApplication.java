package ie.ait.bteam.drcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DrcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrcareApplication.class, args);
	}

}
