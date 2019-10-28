package cdm.depaul.edu.se480.homework3.movierecommendationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cdm.depaul.edu.se480.homework3.movierecommendationservice.service.MovieRecommendationService;

@RestController
public class MovieRecommenationServiceController {
	
	@Autowired
	private MovieRecommendationService movieRecommendationService;
	
	@GetMapping("/getRecommendedMovies")
	public List<String> getMovies() {
		return movieRecommendationService.getRecommendedMovies();
	}
}
