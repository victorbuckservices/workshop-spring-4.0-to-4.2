package demo._42.cors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nlabrot on 15/09/15.
 */
@Controller
public class CorsController {

    @RequestMapping(value = "/ws/cors" , method = {RequestMethod.GET,RequestMethod.POST})
    @CrossOrigin(origins = "*")
    @ResponseBody
    public String cors(){
        return "success";
    }

    @RequestMapping(value = "/ws/nocors" , method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String noCors(){
        return "should not be q success";
    }


    @RequestMapping(value = "/cors" )
    public String corsPage(){
        return "cors";
    }


}
