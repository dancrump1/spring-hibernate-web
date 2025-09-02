package dbs.student_test.service;

import dbs.student_test.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryService extends JpaRepository<Category, Integer> {

}
