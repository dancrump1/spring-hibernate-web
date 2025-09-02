package dbs.student_test;

import dbs.student_test.dao.StudentDAO;
import dbs.student_test.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
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

    public String queryForStudentFirstNameByLastName(StudentDAO studentDAO) {
        Optional<Student> tempStudents = studentDAO.findById(4);
        tempStudents.ifPresent(student -> System.out.println(student.getFirstName()));

        return tempStudents.map(Student::getFirstName).orElse(null);

    }

    private void queryForStudents(StudentDAO studentDAO) {
        for (Student tempStudent : studentDAO.findAll()) {
            System.out.println(tempStudent.getFirstName());
        }
    }

    private void readStudentWithID1(StudentDAO studentDAO) {
        Optional<Student> myStudent = studentDAO.findById(1);
        myStudent.ifPresent(student -> System.out.println(student.getFirstName()));
    }

    private void CreateStudent(StudentDAO studentDAO) {
//      Create new student with hardcoded values
        Student tempStudent = new Student("duck;", "dddd", "dsajdfonsdasdfkiafd@sdafayeu");
//
//       Save student
        studentDAO.save(tempStudent);
    }
}