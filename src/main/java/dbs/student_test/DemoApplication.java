package dbs.student_test;

import dbs.student_test.dao.CategoryDAO;
import dbs.student_test.dao.ComponentDAO;
import dbs.student_test.entity.Category;
import dbs.student_test.entity.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PatchMapping;

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

    //  Fetch Categories -- DONE IN SERVICE


    //    FetchComponents -- DONE IN SERVICE


//    Add Category -- DONE IN SERVICE

//    Add component(s) to category
//    remove component(s) from category
//    delete category
//    Add/update category description
//
}