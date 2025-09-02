package dbs.student_test.controller;

import dbs.student_test.dao.StudentDAO;
import dbs.student_test.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public String getStudent(
            Model model,
            @RequestParam(required = false, name = "id") Integer name
    ) {
//        Create variable to hold list of students
        Optional<Student> tempStudents;

//        Get list of students containing the last name
        tempStudents = studentDAO.findById(name);

//        Create variable of 'something' and assign value of hardcoded string
        model.addAttribute("something", "this is something");

//        Create variable to hold first student with last name
        Student firstStudent;

        if (tempStudents.isPresent()) {
//        Assign first DB entry to variable
            firstStudent = new Student("john", tempStudents.get().getLastName(), "john@semor");
//
//        Create variable 'student' and assign value of list of single student
        model.addAttribute("student", List.of(firstStudent));
        }

//      matches student.html
        return "student";
    }
}
