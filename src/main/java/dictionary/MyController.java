package dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;

@RestController
public class MyController {

    private final
    JdbcTemplate jdbcTemplate;

    @Autowired
    public MyController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/custom")
    public String custom() {
        return "index";
    }

    @RequestMapping(value = "/test", produces = "text/plain")
    public String test(@RequestParam("id") String id) {
        return "your id = " + id;
    }

    @RequestMapping(value = "/addBook", produces = "text/plain")
    public String tester(@RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("year") String year) {
        try {
            String myQuery = "insert into books (author, title, printyear) VALUES (" + author + "," + title + "," + year + ")";
            jdbcTemplate.execute(myQuery);
            return "success";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/login", produces = "text/plain")
    public String login(@RequestParam("name") String name, @RequestParam("passw") String passwd) {
        try{
            ResultSet rs
        }
        return "";
    }
}
