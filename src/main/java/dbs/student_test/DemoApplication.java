//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dbs.student_test;

import dbs.student_test.dao.StudentDAO;
import dbs.student_test.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return (runner) -> {
//            this.CreateStudent(studentDAO);
//            this.readStudent(studentDAO);
//            this.queryForStudents(studentDAO);
//            this.queryForStudentsByLastName(studentDAO);

//            Fetch user from database

//
//            Pass user first name to controller

//            Render the users name from the database
        };
    }

    public String queryForStudentFirstNameByLastName(StudentDAO studentDAO) {
        List<Student> tempStudents = studentDAO.findByLastName("duck");
        for(Student tempStudent : tempStudents) {
            System.out.println(tempStudent.getFirstName());
        }
        return tempStudents.getFirst().getFirstName();
    }

    private void queryForStudents(StudentDAO studentDAO) {
        for(Student tempStudent : studentDAO.findAll()) {
            System.out.println(tempStudent.getFirstName());
        }

    }

    private void readStudent(StudentDAO studentDAO) {
        Student myStudent = studentDAO.findById(1);
        System.out.println(myStudent.getFirstName());
    }

    private void CreateStudent(StudentDAO studentDAO) {
        System.out.println("creating");
        Student tempStudent = new Student("duck;", "dddd", "dsajdfonsdasdfkiafd@sdafayeu");
        System.out.println("saving");
        studentDAO.save(tempStudent);
        System.out.println("saved" + tempStudent.getId());
    }
}
