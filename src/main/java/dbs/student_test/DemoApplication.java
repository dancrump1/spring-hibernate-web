package dbs.student_test;

import dbs.student_test.dao.CategoryDAO;
import dbs.student_test.dao.ComponentDAO;
import dbs.student_test.entity.Category;
import dbs.student_test.entity.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (runner) -> {
            System.out.println("Running IJWdotAI");
        };
    }

//    Basic application usage
//    1. fetch categories and the components contained within
//    2. If no categories, show field on frontend to create first category
//    3. If category contains no component, show list of all components and ability to send selected copmoennt to save as a compoennt within the category
//    4. Allow editing title and description of categories
//    5. Allow editing the description of the components

    //  Fetch Categories
    //  TODO: move to service and tie into endpoint?
    private List<Category> fetchCategories(CategoryDAO categoryDao) {
        System.out.println("fetchCategory");

        Category tempCategory;

        if (categoryDao.findAll().isEmpty()) {
            tempCategory = new Category("new_category");
            categoryDao.save(tempCategory);
        }

        return categoryDao.findAll();
    }

    //    FetchComponents
    //    TODO: Move to service and tie into endpoint?
    private List<Component> fetchComponents(ComponentDAO componentDao) {

        System.out.println("fetch components");

        return componentDao.findAll();
    }

//    Add Category
//    Add component(s) to category
//    remove component(s) from category
//    delete category
//    Add/update category description
//
}