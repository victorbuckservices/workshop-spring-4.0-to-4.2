package demo._42.interceptor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by nlabrot on 18/09/15.
 */
@Controller
public class RequestInterceptorController {

    @RequestMapping(value = "/ws/interceptor", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity interceptor(@RequestBody String s){
        return ok("See log " + s);
    }

    @RequestMapping("/interceptor")
    public String interceptorPage(){
        return "interceptor";
    }
}
