package controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/hii")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}
