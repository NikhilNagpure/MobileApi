package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@RequestMapping("/hi")
	public String sayHi() {
		
		return ("hi nikhil good to see you :) ");
	}

}
