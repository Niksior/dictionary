package dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping(value = "/custom")
    public String custom() {
        return "index";
    }
}
