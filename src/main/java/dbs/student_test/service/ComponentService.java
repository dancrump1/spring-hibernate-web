package dbs.student_test.service;

import dbs.student_test.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentService extends JpaRepository<Component, Integer> {


}
