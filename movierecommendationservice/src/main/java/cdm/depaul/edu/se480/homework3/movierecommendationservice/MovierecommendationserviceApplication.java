package cdm.depaul.edu.se480.homework3.movierecommendationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import cdm.depaul.edu.se480.homework3.userservice.controller.UserServiceController;
import cdm.depaul.edu.se480.homework3.userservice.controller.UserServiceControllerImpl;

@SpringBootApplication
@EnableCircuitBreaker
public class MovierecommendationserviceApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MovierecommendationserviceApplication.class, args);
	}

}
