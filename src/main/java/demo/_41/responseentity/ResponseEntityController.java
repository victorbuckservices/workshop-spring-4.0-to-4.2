package demo._41.responseentity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nlabrot on 01/09/15.
 */
@RestController
public class ResponseEntityController {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseEntityController.class);

    @RequestMapping("/ws/responseentity")
    public ResponseEntity index(@RequestParam(value = "id", required = false) String id)  {
        if (id != null){
            return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(id);
        }else{
            return ResponseEntity.badRequest().body("missing id");
        }
    }
}
