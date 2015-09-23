package demo._42.cache;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.springframework.http.CacheControl.maxAge;
import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by nlabrot on 16/09/15.
 */
@Controller
public class CachedController {

    @ResponseBody
    @RequestMapping(value = "/ws/cache", method = RequestMethod.GET)
    public ResponseEntity cache(){
        return ok().cacheControl(maxAge(5 , SECONDS).cachePublic()).body(LocalDateTime.now());
    }


    @RequestMapping("/cache")
    public String cachePage(){
        return "cache";
    }
}
