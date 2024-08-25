package javaclass3.javaclass3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
public class controller {
    @RequestMapping(value = "/books")
    @ResponseBody
    public String getbooksBySimplePath() {
        return "Simple Get some books";
    }

    @RequestMapping(value = "/books/{id}")
    @ResponseBody
    public String getBookId(@PathVariable final long id) {
        return " BOOk id ="+id;
    }
    @DeleteMapping(value ="/books/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable final long id) {
        return "Book is deleted"+id;
    }
    @PutMapping(value ="/books/{id}")
    @ResponseBody
    public String putBook(@PathVariable final long id) {
        return "Book is Update"+id;
    }
    @PostMapping(value ="/books/{id}")
    @ResponseBody
    public String postBook(@PathVariable final long id) {
        return "Book is inserted"+id;
    }

}
