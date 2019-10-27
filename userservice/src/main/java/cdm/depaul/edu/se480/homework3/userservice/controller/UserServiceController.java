package cdm.depaul.edu.se480.homework3.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface UserServiceController {
	
	@GetMapping("/getAge")
	public int getAge() throws Exception;

}
