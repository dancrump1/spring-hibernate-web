package dbs.student_test.rest;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/test")
public class DemoRestController{

    @GetMapping("/hello")
    public String sayHello() {
        return "hello world";
    }
}
