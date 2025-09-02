package dbs.student_test.dao;

import dbs.student_test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentDAO extends JpaRepository<Student, Integer> {

}