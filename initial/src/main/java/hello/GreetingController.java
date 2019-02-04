package hello;

import model.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/contacts")
    public String contacts(@RequestParam(name = "name", required = false, defaultValue = "sample text") String name,
                           @RequestParam(name = "phone", required = false, defaultValue = "sample text") String phone,
                           @RequestParam(name = "email", required = false, defaultValue = "sample text") String email,
                           Model model) {
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("email", email);

        return "contacts";
    }

    @GetMapping("/about")
    public String about(@RequestParam(name = "education", required = false, defaultValue = "sample text") String education,
                        @RequestParam(name = "job", required = false, defaultValue = "sample text") String job,
                        @RequestParam(name = "projects", required = false, defaultValue = "sample text") String projects,
                        Model model) {
        model.addAttribute("education", education);
        model.addAttribute("job", job);
        model.addAttribute("projects", projects);
        return "about";
    }

    @GetMapping("/news")
    public String news(@RequestParam(name = "news", required = false, defaultValue = "sample text") String[] news,
                       Model model, File newsFile) {

        model.addAttribute("news", news);
        return "news";
    }
}