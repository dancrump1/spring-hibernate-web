package dbs.student_test.service;

import dbs.student_test.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category patchedCategory);

    List<Category> findAll();

    Category findByTitle(String var1);

    Category findById(int var1);

    Category findByName(String var1);

}
