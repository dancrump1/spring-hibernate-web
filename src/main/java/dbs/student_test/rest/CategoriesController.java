package dbs.student_test.rest;

import dbs.student_test.entity.Category;
import dbs.student_test.service.CategoryServiceImpl;
import dbs.student_test.entity.Component;
import dbs.student_test.service.ComponentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/category")
public class CategoriesController {

    private final CategoryServiceImpl categoryService;

    public CategoriesController(CategoryServiceImpl categoryService, ComponentServiceImpl componentService) {
        this.categoryService = categoryService;
        this.componentService = componentService;
    }

    private ComponentServiceImpl componentService;

    public void DemoComponentController(ComponentServiceImpl componentService) {
        this.componentService = componentService;
    }

    @GetMapping("/name/{category_name}")
    public String findByTitle(@PathVariable String category_name) {
        Category category = categoryService.findByTitle(category_name);

        if (category != null) {
            return "Found Category: " + category.getTitle() + " " + category.getDescription() + " " + category.getId();
        } else {
            throw new ComponentNotFoundException("Category not found: " + category_name);
        }
    }

    @GetMapping("/name")
    public Map<String, List<String>> findAll() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            throw new ComponentNotFoundException("Categories not found: ");

        }

        List<Component> components = componentService.findAll();
        if (components.isEmpty()) {
            throw new ComponentNotFoundException("Components not found: ");
        }
        // Build a lookup map: id → title
        Map<Integer, String> categoryIdToTitle = categories.stream()
                .collect(Collectors.toMap(Category::getId, Category::getTitle));

        Map<String, List<String>> categoriesMap = new LinkedHashMap<>();

        for (Component component : components) {
            String raw = component.getCategories();
            if (raw != null && !raw.isBlank()) {
                // remove brackets and whitespace: "[1,2]" → "1,2"
                String cleaned = raw.replaceAll("[\\[\\]]", "");
                String[] catIds = cleaned.split(",");

                for (String catIdStr : catIds) {
                    if (!catIdStr.isBlank()) {
                        int catId = Integer.parseInt(catIdStr.trim());
                        String categoryTitle = categoryIdToTitle.get(catId);

                        if (categoryTitle != null) {
                            categoriesMap.computeIfAbsent(categoryTitle, k -> new ArrayList<>())
                                    .add(component.getName());
                        }
                    }
                }
            }
        }

        return categoriesMap;
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
