package dbs.student_test.rest;

import dbs.student_test.entity.Component;
import dbs.student_test.service.ComponentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@CrossOrigin(origins = "https://components.drivedev.net/")
@RestController
@RequestMapping("/components")
public class DemoComponentController {

    private final ComponentService componentService;

    public DemoComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping
    public String home() {
        return "home_page";
    }

    @GetMapping("/name/{component_name}")
    public String findByTitle(@PathVariable Integer component_name) {

        Optional<Component> component = componentService.findById(component_name);

        if (component.isPresent()) {
            return "Found component: " + component.get().getName() + " " + component.get().getDescription() + " " + component.get().getCategories();
        } else {
            throw new ComponentNotFoundException("Component not found: " + component_name);
        }
    }

    @GetMapping("/category/{categoryId}")
    public Stream<String> findByCategory(@PathVariable Integer categoryId) {

        Optional<List<Component>> component = Optional.of(componentService.findAllById(Collections.singleton(categoryId)));

        List<Component> theComponent = null;


        theComponent = component.get();

        return theComponent.stream().map(item -> {
            return "Found component: " + item.getName() + " " + item.getDescription() + " " + item.getCategories();
        });
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
