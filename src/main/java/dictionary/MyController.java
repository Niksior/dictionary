package dictionary;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    @RequestMapping(value = "/")
    public String custom() {
        return "index";
    }
}
