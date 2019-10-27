package cdm.depaul.edu.se480.homework3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cdm.depaul.edu.se480.homework3.userservice.controller.UserServiceController;
import cdm.depaul.edu.se480.homework3.userservice.controller.UserServiceControllerImpl;

@SpringBootApplication
public class Homework3Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Homework3Application.class, args);
	}

}
