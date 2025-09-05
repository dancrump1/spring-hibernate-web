package dbs.student_test.rest;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://components.drivedev.net/")
@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello world";
    }
}
