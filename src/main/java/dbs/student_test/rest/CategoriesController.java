package dbs.student_test.rest;

import dbs.student_test.entity.Category;
import dbs.student_test.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3006")
@RestController
@RequestMapping("/category")
public class CategoriesController {

    private final CategoryServiceImpl categoryService;

    public CategoriesController(CategoryServiceImpl categoryService){
        this.categoryService= categoryService;
    }

    @GetMapping("/name/{category_name}")
    public String findByTitle(@PathVariable String category_name){
        Category category = categoryService.findByTitle(category_name);

        if (category != null) {
            return "Found Category: " + category.getTitle() + " " + category.getDescription() + " " + category.getId();
        } else {
            throw new ComponentNotFoundException("Category not found: " + category_name);
        }
    }

    @GetMapping("/name")
    public List<Category> findAll(){
        List<Category> categories = categoryService.findAll();

        if (!categories.isEmpty()) {
            return categories;
        } else {
            throw new ComponentNotFoundException("Categories not found: ");
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
