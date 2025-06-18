package dbs.student_test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping
    String getStudent(Model model) {
        model.addAttribute("something", "this is something");

        return "student";
    }
}
