package dbs.student_test.rest;

import dbs.student_test.dao.ComponentDAOImpl;
import dbs.student_test.entity.Component;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

       Component component = componentDAO.findByTitle(component_name);

        if (component != null) {
            return "Found component: " + component.getName() + " " + component.getDescription() + " " + component.getCategories();
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
