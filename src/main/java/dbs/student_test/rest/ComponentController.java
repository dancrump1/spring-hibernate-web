package dbs.student_test.rest;

import dbs.student_test.entity.Component;
import dbs.student_test.service.ComponentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@CrossOrigin(origins = { "https://ijwdotai.com", "https://components.drivedev.net", "http://localhost:3006" })
@RestController
@RequestMapping("/components")
public class ComponentController {

    private final ComponentService componentService;

    public ComponentController(ComponentService componentService) {
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
            return "Found component: " + component.get().getTitle() + " " + component.get().getDescription() + " "
                    + component.get().getCategories();
        } else {
            throw new ComponentNotFoundException("Component not found: " + component_name);
        }
    }

    @GetMapping("/category/{categoryId}")
    public Stream<String> findByCategory(@PathVariable Integer categoryId) {

        Optional<List<Component>> component = Optional
                .of(componentService.findAllById(Collections.singleton(categoryId)));

        List<Component> theComponent = null;

        theComponent = component.get();

        return theComponent.stream().map(item -> {
            return "Found component: " + item.getTitle() + " " + item.getDescription() + " " + item.getCategories();
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

    @PutMapping("/new/component")
    public void addComponent(
            @RequestBody Map<String, String> requestBody) {
        Component newComponent = new Component();

        newComponent.setTitle(requestBody.get("title"));
        newComponent.setDescription(requestBody.get("description"));

        componentService.save(newComponent);
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
