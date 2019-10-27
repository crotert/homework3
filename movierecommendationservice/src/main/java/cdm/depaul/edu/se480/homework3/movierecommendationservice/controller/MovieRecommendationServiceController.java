package cdm.depaul.edu.se480.homework3.movierecommendationservice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public interface MovieRecommendationServiceController {
	@GetMapping("/getRecommendedMovies")
	public List<String> getRecommendedMovies() throws Exception;
}
