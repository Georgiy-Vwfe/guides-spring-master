package hello;

import model.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
    public String news(Model model) {
        model.addAttribute("news", newsSetup());
        return "news";
    }

    private List<String> newsSetup() {
        List<News> list = new ArrayList<>();
        List<String> news = null;
        News n1 = new News("T1", "c1");
        News n2 = new News("T2", "c2");
        News n3 = new News("T3", "c3");
        list.add(n1);
        list.add(n2);
        list.add(n3);

        try {
            NewsReader.write(list, Paths.get("src\\main\\resources\\files\\news"));
        } catch (IOException e) {
            System.out.println("Write Error: \n" + e);
        }
        try {
            news = NewsReader.read(Paths.get("src\\main\\resources\\files\\news"));
        } catch (IOException e) {
            System.out.println("Read Error: \n" + e);
        }
        return news;
    }
}