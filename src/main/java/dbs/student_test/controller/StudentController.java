package dbs.student_test.controller;

import dbs.student_test.dao.StudentDAOImpl;
import dbs.student_test.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentDAOImpl studentDAO;

    @Autowired
    public StudentController(StudentDAOImpl studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public String getStudent(
            Model model,
            @RequestParam(required = false, name = "name") String name
    ) {
//        Create variable to hold list of students
        List<Student> tempStudents;

//        Get list of students containing the last name
        tempStudents = studentDAO.findByLastName(name);

//        Create variable of 'something' and assign value of hardcoded string
        model.addAttribute("something", "this is something");

//        Create variable to hold first student with last name
        Student firstStudent;

//        Assign first DB entry to variable
        firstStudent = new Student("john", tempStudents.getFirst().getLastName(), "john@semor");
//
//        Create variable 'student' and assign value of list of single student
        model.addAttribute("student", List.of(firstStudent));

//      matches student.html
        return "student";
    }
}
