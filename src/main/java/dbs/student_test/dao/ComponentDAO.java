package dbs.student_test.dao;

import dbs.student_test.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentDAO extends JpaRepository<Component, Integer> {

}
