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

@CrossOrigin(origins = {"https://ijwdotai.com/", "https://components.drivedev.net"})
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
        private List<String> components;

        public CategoryResponse(String description) {
            this.description = description;
            this.components = new ArrayList<>();
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

        // Build lookup map for categories
        Map<Integer, Category> categoryIdToCategory = categories.stream()
                .collect(Collectors.toMap(Category::getId, c -> c));

        Map<String, CategoryResponse> categoriesMap = new LinkedHashMap<>();

        // ✅ Pre-populate all categories with empty components list
        for (Category category : categories) {
            categoriesMap.put(category.getTitle(), new CategoryResponse(category.getDescription()));
        }

        // Assign components to categories
        for (Component component : components) {
            String raw = component.getCategories();
            if (raw != null && !raw.isBlank()) {
                String cleaned = raw.replaceAll("[\\[\\]]", "");
                String[] catIds = cleaned.split(",");

                for (String catIdStr : catIds) {
                    if (!catIdStr.isBlank()) {
                        int catId = Integer.parseInt(catIdStr.trim());
                        Category category = categoryIdToCategory.get(catId);

                        if (category != null) {
                            categoriesMap
                                    .computeIfAbsent(category.getTitle(),
                                            k -> new CategoryResponse(category.getDescription()))
                                    .getComponents()
                                    .add(component.getName());
                        }
                    }
                }
            }
        }

        return categoriesMap;
    }

    @PatchMapping("/{id}/description")
    public Category updateCategoryDescription(
            @PathVariable int id,
            @RequestBody Map<String, String> requestBody) {

        Optional<Category> tempCategory = categoryService.findById(id);

        if (tempCategory.isEmpty()) {
            throw new ComponentNotFoundException("Category not found with id " + id);
        }

        Category patchedCategory = apply(requestBody, tempCategory.get());

        categoryService.save(patchedCategory);

        return patchedCategory;
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
