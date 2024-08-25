package javaclass3.javaclass3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/get/book")
public class controller2 {
    @GetMapping("/by-title/{id}")
    @ResponseBody
    public String getBook(@PathVariable final Long  id) {
        return "Get books by title: " + id;
    }

    @GetMapping("/by-simple-path/{id}")
    @ResponseBody
    public String getbooksBySimplePath(@PathVariable final Long  id) {
        return "Get books by simple path: " + id;
    }

    @GetMapping("/")
    @ResponseBody
    public String getBookDetails(@RequestParam ("name") String name,
                                 @RequestParam("publish") String publish) {
        return "Book details: name=" + name + ", publish=" + publish;
    }
}