package dbs.student_test;

import dbs.student_test.dao.StudentDAO;
import dbs.student_test.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    String getStudent(Model model, @RequestParam(required = false, name = "name") String name) {
        model.addAttribute("something", "this is something");
        model.addAttribute("student", List.of(new Student("john", name, "john@semor")));

//        Return same name as html file
        return "student";
    }
}
