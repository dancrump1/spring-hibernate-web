package dbs.student_test;

import dbs.student_test.dao.StudentDAO;
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

    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public String getStudent(
            Model model,
            @RequestParam(required = false, name = "name") String name
    ) {
        List<Student> tempStudents;

            tempStudents = studentDAO.findByLastName(name);


        model.addAttribute("something", "this is something");


            Student firstStudent = new Student("john", tempStudents.getFirst().getLastName(), "john@semor");
            model.addAttribute("student", List.of(firstStudent));


        return "student"; // matches student.html
    }
}
