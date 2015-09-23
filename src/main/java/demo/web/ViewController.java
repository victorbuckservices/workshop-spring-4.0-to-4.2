package demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nlabrot on 01/09/15.
 */
@Controller
@CrossOrigin
public class ViewController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
