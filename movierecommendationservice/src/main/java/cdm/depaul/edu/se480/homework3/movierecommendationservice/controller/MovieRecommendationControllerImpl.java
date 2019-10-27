package cdm.depaul.edu.se480.homework3.movierecommendationservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class MovieRecommendationControllerImpl implements MovieRecommendationServiceController {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="defaultMovies")
	public List<String> getRecommendedMovies() throws Exception {
			int age = restTemplate.getForObject("http://localhost:8081/getAge", int.class);
			if (age < 13) {
				return Arrays.asList("Shrek", "Coco", "The Incredibles");
			}
			else if (age >= 13 && age < 17) {
				return Arrays.asList("The Avengers", "The Dark Knight", "Inception");
			}
			else {
				return Arrays.asList("The Godfather", "Deadpool", "Saving Private Ryan");
			}
	}
	
	private List<String> defaultMovies() {
		return Arrays.asList("Shrek", "Coco", "The Incredibles");
	}
}
