package dbs.student_test;

import dbs.student_test.dao.StudentDAO;
import dbs.student_test.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class StudentController {

    @GetMapping
    String getStudent(Model model) {
        model.addAttribute("something", "this is something");
        model.addAttribute("student", Arrays.asList(new Student("john", "semor", "john@semor"), new Student("jim", "bob", "jim@bob")));

        return "student";
    }
}
