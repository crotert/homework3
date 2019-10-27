package cdm.depaul.edu.se480.homework3.userservice.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceControllerImpl implements UserServiceController {

	public int getAge() throws Exception {
		Random random = new Random();
		int age = random.nextInt(50);
		return age;
	}

}
