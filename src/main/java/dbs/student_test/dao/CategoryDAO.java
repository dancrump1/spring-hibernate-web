package dbs.student_test.dao;


import dbs.student_test.entity.Category;

import java.util.List;

public interface CategoryDAO {
    void save(Category var1);

    Category findById(Integer var1);

    List<Category> findAll();

    Category findByTitle(String var1);
}
