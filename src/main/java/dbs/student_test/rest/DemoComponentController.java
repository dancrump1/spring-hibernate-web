package dbs.student_test.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/components")
public class DemoComponentController {

    @GetMapping("/name/{component_name}")
    public String sayHello(@PathVariable String component_name) {

        if(!Objects.equals(component_name, "3dcard")){
            throw new ComponentNotFoundException("Not Found" + component_name);
        }
        return "hello world";
    };

    @ExceptionHandler
    public ResponseEntity<ComponentErrorResponse> handleException(ComponentNotFoundException exc) {
        ComponentErrorResponse error = new ComponentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    };
}
