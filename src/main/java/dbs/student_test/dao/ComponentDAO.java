package dbs.student_test.dao;

import dbs.student_test.entity.Component;

import java.util.List;
import java.util.Optional;



public interface ComponentDAO {
    void save(Component var1);

    Optional<Component> findByTitle(String var1);

    List<Component> findAll();

    List<Component> findByCategory(int var1);
}
