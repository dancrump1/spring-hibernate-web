package dbs.student_test.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dbs.student_test.entity.Category;
import dbs.student_test.service.CategoryService;
import dbs.student_test.entity.Component;
import dbs.student_test.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"https://ijwdotai.com/", "https://components.drivedev.net", "http://localhost:3006"})
@RestController
@RequestMapping("/category")
public class CategoriesController {

    private final CategoryService categoryService;
    private ComponentService componentService;
    private final ObjectMapper objectMapper;

    @Autowired
    public CategoriesController(CategoryService theCategoryService, ComponentService theComponentService, ObjectMapper theObjectmapper) {
        categoryService = theCategoryService;
        componentService = theComponentService;
        objectMapper = theObjectmapper;
    }


    public void DemoComponentController(ComponentService theComponentService) {
        componentService = theComponentService;
    }

    @GetMapping("/name/{category_name}")
    public Category findByTitle(@PathVariable Integer category_name) {
        Optional<Category> category = categoryService.findById(category_name);

        if (category.isPresent()) {
            return category.get();
        } else {
            throw new ComponentNotFoundException("Category not found: " + category_name);
        }
    }

    // DTO for the response
    public static class CategoryResponse {
        private String description;
        private int id;
        private List<String> components;
        private String name;

        public CategoryResponse(String description, int id, String name) {
            this.description = description;
            this.id = id;
            this.components = new ArrayList<>();
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        // getters & setters
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getComponents() {
            return components;
        }

        public void setComponents(List<String> components) {
            this.components = components;
        }
    }

    @GetMapping("/name")
    public Map<String, CategoryResponse> findAll() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            throw new ComponentNotFoundException("Categories not found");
        }

        List<Component> components = componentService.findAll();
        if (components.isEmpty()) {
            throw new ComponentNotFoundException("Components not found");
        }

        // Pre-populate all categories with empty components list
        Map<String, CategoryResponse> categoriesMap = new LinkedHashMap<>();
        for (Category category : categories) {
            categoriesMap.put(category.getTitle(), new CategoryResponse(category.getDescription(), category.getId(), category.getTitle()));
        }

        // Assign components to their categories
        for (Component component : components) {
            for (Category category : component.getCategories()) {
                categoriesMap
                        .computeIfAbsent(category.getTitle(),
                                k -> new CategoryResponse(category.getDescription(), category.getId(), category.getTitle()))
                        .getComponents()
                        .add(component.getTitle());
            }
        }

        return categoriesMap;
    }

    @PatchMapping("/{id}/description")
    public Category updateCategoryDescription(
            @PathVariable int id,
            @RequestBody Map<String, Object> requestBody) {

        Category category = categoryService.findById(id)
                .orElseThrow(() -> new ComponentNotFoundException("Category not found with id " + id));

        // Update description if present
        if (requestBody.containsKey("description")) {
            category.setDescription((String) requestBody.get("description"));
        }

        // Update components if present
        if (requestBody.containsKey("components")) {
            // Assuming frontend sends JSON array of titles: ["Resistor", "Capacitor"]
            List<String> titles = (List<String>) requestBody.get("components");

            // Clear current components first (optional)
//            category.getComponents().clear();

            for (String title : titles) {
                Component component = componentService.findByTitle(title)
                        .orElseThrow(() -> new ComponentNotFoundException("Component not found: " + title));
                List<Component> tempCompList = category.getComponents();

                tempCompList.add(component);
                // Add component using helper method to sync both sides
                category.setComponents(tempCompList);
            }
        }

        // Save the owning side (category)
        return categoryService.save(category);
    }

    private Category apply(Map<String, String> requestBody, Category tempCategory) {
        ObjectNode categoryNode = objectMapper.convertValue(tempCategory, ObjectNode.class);

        ObjectNode patchNode = objectMapper.convertValue(requestBody, ObjectNode.class);

        categoryNode.setAll(patchNode);
        return objectMapper.convertValue(categoryNode, Category.class);
    }

    @PutMapping("/new/category")
    public void addCategory(
            @RequestBody Map<String, String> requestBody
    ) {
        Category newCategory = new Category();

        newCategory.setTitle(requestBody.get("title"));
        newCategory.setDescription(requestBody.get("description"));

        categoryService.save(newCategory);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteCategory(@PathVariable int id) {
        Category categoryToDelete = categoryService.findById(id)
                .orElseThrow(() -> new ComponentNotFoundException("Category not found"));

        categoryService.delete(categoryToDelete);
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
