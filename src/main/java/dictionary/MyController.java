package dictionary;

import dictionary.data.Book;
import dictionary.data.User;
import dictionary.rowmappers.UserRowmapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            return "failed";
        }
    }

    @RequestMapping(value = "/login", produces = "text/html")
    public String login(@RequestParam("name") String name, @RequestParam("passwd") String passwd) {
        try{
            String query = "SELECT * FROM users WHERE login = " + name + " and password = " + passwd;
            loggedUser = (User) jdbcTemplate.queryForObject(query, new UserRowmapper());
            if(loggedUser.isAdmin())
                return "<script>" +
                        "window.open('/menu/index.html', '_parent');" +
                        "close()" +
                        "</script>";
            else
                return "<script>" +
                        "window.open('/menu/user.html', '_parent');" +
                        "close()" +
                        "</script>";
        } catch (Exception e) {
            return "Wrong password or login";
        }
    }

    @RequestMapping(value = "/addUser", produces = "text/html")
    public String addUser(@RequestParam("login") String login,
                          @RequestParam("name") String name,
                          @RequestParam("surname") String surname,
                          @RequestParam("password") String password,
                          @RequestParam("isAdmin") String isAdmin,
                          @RequestParam("PESEL") String pesel){
        try{
            boolean admin;
            admin = !isAdmin.equalsIgnoreCase("'false'");
            String query = "INSERT INTO users (login, password, isadmin, firstname, surname, pesel ,registerdate) VALUES (" +
                    login + ", " +
                    password + ", " +
                    admin + ", " +
                    name + ", " +
                    surname + ", " +
                    pesel + ", " +
                    "clock_timestamp())";
            jdbcTemplate.execute(query);
            return "Welcome in library " + name + "!";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/showBook", produces = "text/html")
    public String showBook(@RequestParam("title") String title) {
        try {
            String query;
            if(title.equals("'*'")) {
                query = "SELECT * FROM books;";
            } else {
                query = "SELECT * FROM books WHERE title = " + title;
            }

            String output = "";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
            for(Map row : rows) {
                Book book = new Book();
                book.setId((Integer) (row.get("ID")));
                book.setAuthorName((String) (row.get("authorName")));
                book.setAuthorSurname((String) (row.get("authorSurname")));
                book.setTitle((String) (row.get("title")));
                book.setIsAway((boolean) row.get("isAway"));
                book.setPrintYear((Integer) row.get("printYear"));
                output += book.toString();
            }
            return output;
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/rentBook", produces = "text/html")
    public String rentBook(@RequestParam("id") String id) {
        try {
            if(loggedUser.getLogin() == null) {
                return "You are logged out. <br/> Go to login page.";
            }
            String query = "SELECT * FROM books WHERE id = " + id;
            Book book = new Book();
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
            if(rows.size() < 1) {
                return "Wrong ID";
            }
            for(Map row : rows) {
                book.setId((Integer) (row.get("ID")));
                book.setAuthorName((String) (row.get("authorName")));
                book.setAuthorSurname((String) (row.get("authorSurname")));
                book.setTitle((String) (row.get("title")));
                book.setIsAway((boolean) row.get("isAway"));
                book.setPrintYear((Integer) row.get("printYear"));
            }
            if(book.getIsAway()) {
                return "Book is not in library";
            }
            query = "UPDATE books SET isAway = true WHERE id =" + String.valueOf(book.getId());
            jdbcTemplate.execute(query);
            query = "INSERT INTO loans (loandate, clientLogin, bookId, isreturned) VALUES (" +
                    "clock_timestamp(),'" +
                    loggedUser.getLogin() + "', " +
                    book.getId() + ", " +
                    "false" +
                    ")";
            jdbcTemplate.execute(query);
            return "Done";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/returnBook", produces = "text/html")
    public String returnBook(@RequestParam("id") String id) {
        try {
            String query = "SELECT * FROM books WHERE id = " + id;
            Book book = new Book();
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
            if(rows.size() < 1) {
                return "Wrong ID";
            }
            for(Map row : rows) {
                book.setId((Integer) (row.get("ID")));
                book.setAuthorName((String) (row.get("authorName")));
                book.setAuthorSurname((String) (row.get("authorSurname")));
                book.setTitle((String) (row.get("title")));
                book.setIsAway((boolean) row.get("isAway"));
                book.setPrintYear((Integer) row.get("printYear"));
            }
            if(!book.getIsAway()) {
                return "Book is in library";
            }
            query = "UPDATE books SET isAway = false WHERE id =" + String.valueOf(book.getId());
            jdbcTemplate.execute(query);
            query = "UPDATE loans SET returndate = clock_timestamp(), isreturned = true WHERE bookid = " + id + " AND isreturned = false;";
            jdbcTemplate.execute(query);
            return "Done";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
