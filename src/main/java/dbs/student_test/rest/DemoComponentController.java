package dbs.student_test.rest;

import dbs.student_test.dao.ComponentDAO;
import dbs.student_test.dao.ComponentDAOImpl;
import dbs.student_test.entity.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/components")
public class DemoComponentController {

    private final ComponentDAOImpl componentDAO;

    public DemoComponentController(ComponentDAOImpl componentDAO) {
        this.componentDAO = componentDAO;
    }


    @GetMapping("/name/{component_name}")
    public String sayHello(@PathVariable String component_name) {

        Optional<Optional<Component>> component = Optional.ofNullable(componentDAO.findByTitle(component_name));

        if (component.isPresent()) {
            return "Found component: " + component.get().getClass();
        } else {
            throw new ComponentNotFoundException("Component not found: " + component_name);
        }
    }

    @ExceptionHandler
    public ResponseEntity<ComponentErrorResponse> handleException(ComponentNotFoundException exc) {
        ComponentErrorResponse error = new ComponentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    };
}
