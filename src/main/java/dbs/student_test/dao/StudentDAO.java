package dbs.student_test.dao;

import dbs.student_test.entity.Student;
import java.util.List;


public interface StudentDAO {
    void save(Student var1);

    Student findById(Integer var1);

    List<Student> findAll();

    List<Student> findByLastName(String var1);
}