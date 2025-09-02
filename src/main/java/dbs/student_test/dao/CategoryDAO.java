package dbs.student_test.dao;


import dbs.student_test.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
