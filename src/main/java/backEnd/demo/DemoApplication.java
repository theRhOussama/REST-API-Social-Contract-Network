package backEnd.demo;

import backEnd.demo.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import backEnd.demo.entity.RoleApp;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "true")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	;


	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {

			accountService.addNewRole(new RoleApp(null, "User"));
			accountService.addNewRole(new RoleApp(null, "ENTREPRISE"));
			accountService.addNewRole(new RoleApp(null, "EMPLOYEE"));


		};


	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/login").allowedOrigins("http://localhost:4200");
			}
		};

	}

}







