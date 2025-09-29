package dbs.student_test.service;

import dbs.student_test.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryService extends JpaRepository<Category, Integer> {

    void delete(Optional<Category> categoryToDelete);
}
