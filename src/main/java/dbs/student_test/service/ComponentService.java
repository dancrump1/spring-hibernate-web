package dbs.student_test.service;

import dbs.student_test.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentService extends JpaRepository<Component, Integer> {


}
