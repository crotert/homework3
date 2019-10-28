package cdm.depaul.edu.se480.homework3.movierecommendationservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import cdm.depaul.edu.se480.homework3.movierecommendationservice.service.MovieRecommendationService;

@SpringBootTest
class MovierecommendationserviceApplicationTests {

	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	//private MovieService movieService = Mockito.mock(MovieService.class);
	private MovieRecommendationService movieService = new MovieRecommendationService();
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetMoviesAgeUnder13() {
		Mockito.when(restTemplate.getForObject("http://localhost:8081/getAge", int.class)).thenReturn(12);		
		List<String> movies = movieService.getRecommendedMovies();		
		List<String> expectedResult = Arrays.asList("Shrek","Coco","The Incredibles");
		assertEquals(expectedResult, movies);
	}
	
	@Test
	public void testGetMoviesAgeIs13() {
		Mockito.when(restTemplate.getForObject("http://localhost:8081/getAge", int.class)).thenReturn(13);
		List<String> movies = movieService.getRecommendedMovies();		
		List<String> expectedResult = Arrays.asList("The Avengers", "The Dark Knight", "Inception");
		assertEquals(expectedResult, movies);
	}
	
	@Test
	public void testGetMoviesAgeIsBetween13and17() {
		Mockito.when(restTemplate.getForObject("http://localhost:8081/getAge", int.class)).thenReturn(15);
		List<String> movies = null;
		try {
			movies = movieService.getRecommendedMovies();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		List<String> expectedResult = Arrays.asList("The Avengers", "The Dark Knight", "Inception");
		assertEquals(expectedResult, movies);		
	}
	
	@Test
	public void testGetMoviesAgeIs17() {
		Mockito.when(restTemplate.getForObject("http://localhost:8081/getAge", int.class)).thenReturn(17);
		List<String> movies = movieService.getRecommendedMovies();	
		List<String> expectedResult = Arrays.asList("The Godfather", "Deadpool", "Saving Private Ryan");
		assertEquals(expectedResult, movies);		
	}
	
	@Test
	public void testGetMoviesAgeIsOver17() {
		Mockito.when(restTemplate.getForObject("http://localhost:8081/getAge", int.class)).thenReturn(20);
		List<String> movies = movieService.getRecommendedMovies();		
		List<String> expectedResult = Arrays.asList("The Godfather", "Deadpool", "Saving Private Ryan");
		assertEquals(expectedResult, movies);		
	}
	
	@Test
	public void testUserServiceUnavailable() {
		Mockito.when(restTemplate.getForObject("http://localhost:8081/getAge", int.class)).thenThrow(RestClientException.class);
		List<String> movies = movieService.getRecommendedMovies();
		List<String> expectedResult = Arrays.asList("Shrek", "Coco", "The Incredibles");
		assertEquals(expectedResult, movies);
	}
}
