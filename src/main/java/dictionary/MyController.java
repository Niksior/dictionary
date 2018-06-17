package dictionary;

import dictionary.data.Book;
import dictionary.data.User;
import dictionary.rowmappers.UserRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.RowSet;
import java.sql.ResultSet;

@RestController
public class MyController {

    private final
    JdbcTemplate jdbcTemplate;

    private User loggedUser;
    private Book [] books;

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
    public String tester(@RequestParam("title") String title, @RequestParam("name") String name, @RequestParam("surname") String surname,@RequestParam("year") String year) {
        try {
            String myQuery = "insert into books (authorName, authorSurname ,title, printyear) VALUES (" + name + "," + surname + "," + title + "," + year + ")";
            jdbcTemplate.execute(myQuery);
            return "success";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/login", produces = "text/plain")
    public String login(@RequestParam("name") String name, @RequestParam("passw") String passwd) {
        try{
            String query = "SELECT login, isAdmin FROM users WHERE login = " + name + " and password = " + passwd;
            //SqlRowSet sqlRowSet =  jdbcTemplate.queryForRowSet(query);
            //boolean isValid = false;
            User user = (User) jdbcTemplate.queryForObject(query, new UserRowmapper());
            if(user.getLogin().equals(name) && user.getPassword().equals(passwd)) {
                loggedUser = user;
                return "Welcome " + loggedUser.getFirstName();
            } else {
                return "Wrong password";
            }
        } catch (Exception e) {
            return e.toString();
        }
    }
}
