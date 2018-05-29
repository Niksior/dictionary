package dictionary;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping(value = "/custom")
    public String custom() {
        return "index";
    }

    @RequestMapping(value = "/test", produces = "application/json")
    public String test(@RequestParam("id") String id) {
        return "your id = " + id;
    }
}
