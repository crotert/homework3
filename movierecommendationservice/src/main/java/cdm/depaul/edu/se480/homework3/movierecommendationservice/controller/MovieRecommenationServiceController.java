package cdm.depaul.edu.se480.homework3.movierecommendationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cdm.depaul.edu.se480.homework3.movierecommendationservice.service.MovieRecommendationService;

@Controller
public class MovieRecommenationServiceController {
	
	@Autowired
	private MovieRecommendationService movieRecommendationService;
	
	@GetMapping("/getRecommendedMovies}")
	public String getGreeting(Model model, @PathVariable("username") String username) {
		model.addAttribute("movies", movieRecommendationService.getRecommendedMovies());
		return "recommendedMovies";
	}

}
