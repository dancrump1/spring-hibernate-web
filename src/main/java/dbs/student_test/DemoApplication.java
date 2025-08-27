package dbs.student_test;

import dbs.student_test.dao.StudentDAOImpl;
import dbs.student_test.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EntityScan("dbs.student_test.entity")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAOImpl studentDAO) {
        return (runner) -> {
//           Create a user
            this.CreateStudent(studentDAO);
//
//            Check user is in DB
            this.readStudentWithID1(studentDAO);
//
//            Fetch user from database
            this.queryForStudents(studentDAO);
        };
    }

    public String queryForStudentFirstNameByLastName(StudentDAOImpl studentDAO) {
        List<Student> tempStudents = studentDAO.findByLastName("duck");
        for (Student tempStudent : tempStudents) {
            System.out.println(tempStudent.getFirstName());
        }
        return tempStudents.getFirst().getFirstName();
    }

    private void queryForStudents(StudentDAOImpl studentDAO) {
        for (Student tempStudent : studentDAO.findAll()) {
            System.out.println(tempStudent.getFirstName());
        }
    }

    private void readStudentWithID1(StudentDAOImpl studentDAO) {
        Student myStudent = studentDAO.findById(1);
        System.out.println(myStudent.getFirstName());
    }

    private void CreateStudent(StudentDAOImpl studentDAO) {
//      Create new student with hardcoded values
        Student tempStudent = new Student("duck;", "dddd", "dsajdfonsdasdfkiafd@sdafayeu");
//
//       Save student
        studentDAO.save(tempStudent);
    }
}