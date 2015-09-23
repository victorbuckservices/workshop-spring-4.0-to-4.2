package demo._42.aliasfor;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.springframework.http.CacheControl.maxAge;
import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by nlabrot on 01/09/15.
 */
@Controller
public class CacheableRestController {

    @CacheableRequRestMapping(path = "/ws/aliasfor", method = RequestMethod.GET , cacheNames = "aliasfor", key = "'alias'")
    @Cacheable(cacheNames = "aliasfor", key = "'alias'")
    public ResponseEntity cache() {
        return ok().cacheControl(maxAge(5 , SECONDS).cachePublic()).body(LocalDateTime.now());
    }

    @EvictRequRestMapping(path = "/ws/aliasfor", method = RequestMethod.PUT, cacheNames = "aliasfor", key = "'alias'")
    @CacheEvict(cacheNames = "aliasfor", key = "'alias'")
    public ResponseEntity evict() {
        return ok("evicted");
    }

    @RequestMapping("/aliasfor")
    public String cachePage(){
        return "aliasfor";
    }

}
