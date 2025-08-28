package dbs.student_test.rest;

import dbs.student_test.entity.Component;
import dbs.student_test.service.ComponentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:3008")
@RestController
@RequestMapping("/components")
public class DemoComponentController {

    private final ComponentServiceImpl componentService;

    public DemoComponentController(ComponentServiceImpl componentService) {
        this.componentService = componentService;
    }

    @GetMapping
    public String home() {
        return "home_page";
    }

    @GetMapping("/name/{component_name}")
    public String findByTitle(@PathVariable String component_name) {

        Component component = componentService.findByTitle(component_name);

        if (component != null) {
            return "Found component: " + component.getName() + " " + component.getDescription() + " " + component.getCategories();
        } else {
            throw new ComponentNotFoundException("Component not found: " + component_name);
        }
    }

    @GetMapping("/category/{categoryId}")
    public Stream<String> findByCategory(@PathVariable int categoryId) {

        List<Component> component = componentService.findByCategory(categoryId);

        if (!component.isEmpty()) {
            return component.stream().map(item -> {
                return "Found component: " + item.getName() + " " + item.getDescription() + " " + item.getCategories();
            });
        } else {
            throw new ComponentNotFoundException("Component not found: " + categoryId);
        }
    }

    @GetMapping("/name")
    public List<Component> findAll() {

        List<Component> component = componentService.findAll();

        if (!component.isEmpty()) {
            return component;
        } else {
            throw new ComponentNotFoundException("Components not found: ");
        }
    }

    @ExceptionHandler
    public ResponseEntity<ComponentErrorResponse> handleException(ComponentNotFoundException exc) {
        ComponentErrorResponse error = new ComponentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
